<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
<body bgcolor= "eeffee">
<h2 align = "center">动漫列表</h2>
<xsl:for-each select="cartoons/cartoon">
	<hr/>
	<div align = "center">
		<img height = "200">
			<xsl:attribute name = "src">
			<xsl:value-of select="@picture"/>				
			</xsl:attribute>
		</img>
		<h2><xsl:value-of select="name"/>：</h2>
		<p>评分：<xsl:value-of select="comments/@score"/>/10</p>
		<p>导演：<xsl:value-of select="made_info/director"/></p>
		<p>声优：<xsl:value-of select="made_info/dubbingor"/></p>
		<p>简介：</p>
			<blockquote><xsl:value-of select="context"/></blockquote>
		<xsl:if test = "count(comments/child::*) > 0">
			<p>评价：</p>
			<xsl:for-each select="comments/comment">
					<blockquote>
						<p><xsl:value-of select="@user"/>：</p>
						<blockquote><xsl:value-of select="."/></blockquote>
						<p><xsl:value-of select="@time"/></p>
						<br/>
					</blockquote>
			</xsl:for-each>
		</xsl:if>
		<p>观看：</p>
		<blockquote>
			<xsl:for-each select="serials/id">
				<button><a>
					<xsl:attribute name = "href">
					<xsl:value-of select="@url"/>				
					</xsl:attribute>
					第<xsl:value-of select="."/>集
				</a></button>
			</xsl:for-each>
		</blockquote>
	</div>
	<hr/>
</xsl:for-each>
</body>
</html>
</xsl:template>

</xsl:stylesheet>