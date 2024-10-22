<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:mdb="http://standards.iso.org/iso/19115/-3/mdb/2.0"
                xmlns:mcc="http://standards.iso.org/iso/19115/-3/mcc/1.0"
                xmlns:gco="http://standards.iso.org/iso/19115/-3/gco/1.0"
                xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns:dct="http://purl.org/dc/terms/"
                exclude-result-prefixes="#all">
  <!-- http://data.europa.eu/930/ -->

  <xsl:import href="eu-geodcat-ap-core.xsl"/>

  <xsl:template match="/">
    <rdf:RDF>
      <xsl:call-template name="create-namespaces-eu-geodcat-ap"/>
      <xsl:apply-templates mode="iso19115-3-to-dcat"
                           select="root/mdb:MD_Metadata|mdb:MD_Metadata"/>
    </rdf:RDF>
  </xsl:template>
</xsl:stylesheet>