<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="xml" encoding="UTF-8"/>

    <xsl:template match="/document">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4"
                                       page-height="29.7cm"
                                       page-width="21cm"
                                       margin="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="NotoSansTamil" font-size="14pt" font-weight="bold">
                        <xsl:value-of select="title"/>
                    </fo:block>
                    <fo:block font-family="NotoSansTamil" font-size="12pt" space-before="10pt">
                        <xsl:value-of select="content"/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>