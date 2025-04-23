<html>
   <head>
      <title>HTTP : 404</title>
      <jsp:include page="/css/main-css.jsp"/>
      <jsp:include page="/css/http-status/http-status-css.jsp"/>
      <jsp:include page="/javascript/main-javascript.jsp"/>
   </head>
   <body>
      <div class="wrapper">
         <div class="header">
            <jsp:include page="/header/resource-not-found-header.jsp"/>
         </div>
         <div class="content-panel">
            <jsp:include page="/body/http-status/404-body.jsp"/>
         </div>
         <div class="sitemap">
            <jsp:include page="/sitemap/sitemap.jsp"/>
         </div>
         <div class="footer">
            <jsp:include page="/footer/footer.jsp"/>
         </div>
      </div>
   </body>
</html>
