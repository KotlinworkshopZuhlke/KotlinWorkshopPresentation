import {dest, parallel, series, src} from 'gulp';
import autoprefixer from 'autoprefixer';
import cssnano from 'cssnano';
import gulpUglify from 'gulp-uglify';
import gulpJshint from 'gulp-jshint';
import gulpConnect from 'gulp-connect';
import sass from 'gulp-sass';
import postcss from 'gulp-postcss';

// Paths
const paths = {
	css: {
		src: 'css/reveal.scss',
		dest: 'css/',
		theme: {
			src: 'css/theme/source/*.{sass,scss}',
			dest: 'css/theme/'
		}
	},
	js: {
		src: 'js/reveal.js',
		dest: 'js/',
		test: 'test/*.html'
	},
	html: '*.html',
	dist: 'reveal-js-presentation.zip'
};

// CSS Task
const cssCore = () => {
	return src(paths.css.src)
		.pipe(sass())
		.pipe(postcss([autoprefixer(), cssnano()]))
		.pipe(dest(paths.css.dest));
};

// Theme CSS Task
const cssThemes = () => {
	return src(paths.css.theme.src)
		.pipe(sass())
		.pipe(dest(paths.css.theme.dest));
};

// JS Task
const js = () => {
	return src(paths.js.src)
		.pipe(gulpJshint())
		.pipe(gulpJshint.reporter('default'))
		.pipe(gulpUglify())
		.pipe(dest(paths.js.dest));
};

// Serve Task
const serve = () => {
	gulpConnect.server({
		root: '.',
		livereload: true,
		port: 8000
	});
};

// Watch Task
const watch = () => {
	gulp.watch(paths.css.src, cssCore);
	gulp.watch(paths.css.theme.src, cssThemes);
	gulp.watch(paths.js.src, js);
	gulp.watch(paths.html).on('change', gulpConnect.reload);
};

// Zip Task
const loadGulpZip = async () => {
	const {default: gulpZip} = await import('gulp-zip');
	return () => {
		return src([
			paths.html,
			'css/**',
			'js/**',
			'lib/**',
			'images/**',
			'plugin/**',
			'**.md'
		])
			.pipe(gulpZip(paths.dist))
			.pipe(dest('.'));
	};
};

// Default Task
const defaultTask = series(parallel(cssCore, cssThemes, js), serve, watch);

// Export tasks
export {
	cssCore,
	cssThemes,
	js,
	serve,
	watch,
	loadGulpZip as package,
	defaultTask as default
};
