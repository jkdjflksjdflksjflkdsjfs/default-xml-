<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
<xsl:template match="/"> 
 <html> 
 <head>
	<title>default小组名片</title>
	<style>
		.div-a{ float:left;width:33%;height:35%;border:1px solid #000} 
		.div-b{ float:left;width:33%;height:35%;border:1px solid #000} 
		.div-c{ float:left;width:33%;height:35%;border:1px solid #000} 
	</style>
 </head>
 <body background="background.png"> 
  <h1 align="center">default小组</h1> 
    <xsl:for-each select="peoples/people">
	<div class="div-a">
    <p style="font-size:22px"  align="center"><u><xsl:value-of select="name"/></u></p>
	<p align="center">性别: <xsl:value-of select="sex"/></p>
	<p align="center">邮箱: <xsl:value-of select="email"/></p>

	</div>
	<div class="div-b">
			<img height="180" width="360">
				<xsl:attribute name = "src">
				<xsl:value-of select="picture"/>				
				</xsl:attribute>
			</img>
	</div>
	<div class="div-c">
		<p align="center" margin-top="-50px"><xsl:value-of select="info"/></p>
	</div>
    </xsl:for-each>  
</body> 
</html> 
</xsl:template> 
</xsl:stylesheet> 