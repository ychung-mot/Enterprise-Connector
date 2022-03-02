<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Drive BC Events</h2>
  <table border="1">
    <tr >
      <th>Headline</th>
      <th>Status</th>
      <th>Updated</th>
      <th>Description</th>
    </tr>
    <xsl:for-each select="Open511Events/events/events">
    <tr>
      <td><xsl:value-of select="headline"/></td>
      <td><xsl:value-of select="status"/></td>
      <td><xsl:value-of select="updated"/></td>
      <td><xsl:value-of select="description"/></td>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>