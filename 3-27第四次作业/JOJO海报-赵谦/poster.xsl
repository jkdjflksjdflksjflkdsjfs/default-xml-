<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
	<body bgcolor= "eeffee">
		<xsl:for-each select="cartoons/cartoon">
			<div align = "center">
				<h2><xsl:value-of select="name"/></h2>
				<img height = "600">
					<xsl:attribute name = "src">
					<xsl:value-of select="@picture"/>				
					</xsl:attribute>
				</img>
				<p>评分：<xsl:value-of select="comments/@score"/>/10</p>
				<p>导演：<xsl:value-of select="made_info/director"/></p>
				<p>声优：<xsl:value-of select="made_info/dubbingor"/></p>
				<blockquote><xsl:value-of select="context"/></blockquote>
		
				</div>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>