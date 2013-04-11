<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
  </head>
  <body>
        <table>
      <tr>
        <td colspan="2" align="center">
          <tiles:insertAttribute name="header" />
        </td>
      </tr>
      <tr>
        <td colspan="1">
          <tiles:insertAttribute name="menu" />
        </td>
        <td colspan="1">
          <tiles:insertAttribute name="body" />
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <tiles:insertAttribute name="footer" />
        </td>
      </tr>
    </table>
  </body>
</html>