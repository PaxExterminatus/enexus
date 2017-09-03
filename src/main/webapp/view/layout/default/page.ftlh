<!doctype html>
<head>
    <title>${title}</title>
    <base href="/enexus/">
    <link rel="stylesheet" href="source/design/style.css">
    <meta charset="${charset}">
</head>

<body>
    <header>
        <h1>${title}</h1>
        <div class="actions">
        <#if viewActions != "">
            <#include "${viewActions}">
        </#if>
        </div>
    </header>
    <section class="main">
        <#if viewMain != "">
            <#include "${viewMain}">
        </#if>
    </section>
    <footer>
        footer
    </footer>
</body>
</html>