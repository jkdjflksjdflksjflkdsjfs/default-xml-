<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
<xsl:template match="/cartoons/cartoon"> 
 <html> 
 <head>
	<title>火影忍者劲爆来袭!</title>
	<style>
		.div-a{ float:left;width:33%;height:35%;border:1px solid #000} 
		.div-b{ float:left;width:33%;height:35%;border:1px solid #000} 
		.div-c{ float:left;width:33%;height:35%;border:1px solid #000} 
	</style>
 </head>
<body background="huoying.jpg" style="background-repeat:no-repeat; background-size:100% 100%; background-attachment: fixed;"> 
<div style="position:fixed; bottom:0px; width:100%; text-align:center;">
	<p style="font-size:40px"  align="center"><u><xsl:value-of select="name"/></u></p>
	<p align="center" style="font-size:15px">内容简介: <xsl:value-of select="context"/></p>
</div>

</body> 
</html> 
</xsl:template> 
</xsl:stylesheet> 