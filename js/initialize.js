// More info https://github.com/hakimel/reveal.js#configuration

Reveal.initialize({
    history: true,

    // More info https://github.com/hakimel/reveal.js#dependencies
    dependencies: [
        {src: '../../plugin/markdown/marked.js'},
        {src: '../../plugin/markdown/markdown.js'},
        {src: '../../plugin/notes/notes.js', async: true},
        {
            src: '../../plugin/highlight/highlight.js', async: true, callback: function () {
                kotlin.initHighlightingOnLoad();
            }
        }
    ]
});

document.addEventListener("DOMContentLoaded", function() {
    const loadExternalHTML = async () => {
        // Find all elements with the attribute data-external
        const externalElements = document.querySelectorAll('[data-external]');

        // Loop through each element and load the external HTML file
        for (let element of externalElements) {
            const filePath = "topic/" + element.getAttribute('data-external');

            try {
                const response = await fetch(filePath);
                if (response.ok) {
                    const content = await response.text();
                    element.innerHTML = content;
                } else {
                    console.error(`Error loading ${filePath}: ${response.statusText}`);
                }
            } catch (error) {
                console.error(`Fetch error for ${filePath}:`, error);
            }
        }
    };

    // Call the function to load external HTML
    loadExternalHTML();
});