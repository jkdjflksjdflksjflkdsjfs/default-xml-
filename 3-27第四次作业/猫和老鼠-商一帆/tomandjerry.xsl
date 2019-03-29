<?xml version="1.0" encoding="UTF-8"?> 
<xsl:stylesheet version="1.0" 
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">  
<xsl:template match="/cartoons/cartoon"> 
 <html> 
<body background="tomandjerry.jpg" style="background-repeat:no-repeat; background-size:100% 100%; background-attachment: fixed;"> 
<div style="position:fixed; bottom:0px; width:100%; text-align:center;">
  <font color="yellow" align="center" style="font-size:35px"  ><u><xsl:value-of select="name"/>---经典重温！！！</u></font>
	<p align="center" style="font-size:25px">导演: <xsl:value-of select="made_info/director"/></p>
	<p align="center" style="font-size:20px">内容简介: <xsl:value-of select="context"/></p>
</div>

</body> 
</html> 
</xsl:template> 
</xsl:stylesheet> 


