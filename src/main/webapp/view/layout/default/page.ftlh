<#ftl auto_esc=false>
<!doctype html>
<head>
    <title>${title}</title>
    <base href="${base}">
    <link rel="stylesheet" href="source/design/style.css">
    <meta charset="${charset}">
    <meta name="viewport" content="width=device-width" />
</head>

<body>

    <header>
        <h1>${title}</h1>
        <div class="actions">
        ${viewActions}
        </div>
    </header>

    <section class="main-context">
        <#if viewMain != ""><#include "${viewMain}"></#if>
    </section>

    <footer>
        footer
    </footer>
</body>
</html>