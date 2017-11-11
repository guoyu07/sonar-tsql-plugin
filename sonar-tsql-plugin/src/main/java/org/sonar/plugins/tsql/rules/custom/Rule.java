//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.11 at 05:57:50 PM EET 
//


package org.sonar.plugins.tsql.rules.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}key"/>
 *         &lt;element ref="{}name"/>
 *         &lt;element ref="{}internalKey"/>
 *         &lt;element ref="{}descriptionFormat"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}severity"/>
 *         &lt;element ref="{}cardinality"/>
 *         &lt;element ref="{}status"/>
 *         &lt;element ref="{}remediationFunction"/>
 *         &lt;element ref="{}remediationFunctionBaseEffort"/>
 *         &lt;element ref="{}debtRemediationFunctionCoefficient"/>
 *         &lt;element ref="{}tag"/>
 *         &lt;element ref="{}ruleImplementation"/>
 *         &lt;element ref="{}source"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "key",
    "name",
    "internalKey",
    "descriptionFormat",
    "description",
    "severity",
    "cardinality",
    "status",
    "remediationFunction",
    "remediationFunctionBaseEffort",
    "debtRemediationFunctionCoefficient",
    "tag",
    "ruleImplementation",
    "source"
})
@XmlRootElement(name = "rule")
public class Rule {

    @XmlElement(required = true)
    protected String key;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String internalKey;
    @XmlElement(required = true)
    protected String descriptionFormat;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String severity;
    @XmlElement(required = true)
    protected String cardinality;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected String remediationFunction;
    @XmlElement(required = true)
    protected String remediationFunctionBaseEffort;
    @XmlElement(required = true)
    protected String debtRemediationFunctionCoefficient;
    @XmlElement(required = true)
    protected String tag;
    @XmlElement(required = true)
    protected RuleImplementation ruleImplementation;
    @XmlElement(required = true)
    protected String source;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the internalKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalKey() {
        return internalKey;
    }

    /**
     * Sets the value of the internalKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalKey(String value) {
        this.internalKey = value;
    }

    /**
     * Gets the value of the descriptionFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptionFormat() {
        return descriptionFormat;
    }

    /**
     * Sets the value of the descriptionFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptionFormat(String value) {
        this.descriptionFormat = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the cardinality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardinality() {
        return cardinality;
    }

    /**
     * Sets the value of the cardinality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardinality(String value) {
        this.cardinality = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the remediationFunction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemediationFunction() {
        return remediationFunction;
    }

    /**
     * Sets the value of the remediationFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemediationFunction(String value) {
        this.remediationFunction = value;
    }

    /**
     * Gets the value of the remediationFunctionBaseEffort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemediationFunctionBaseEffort() {
        return remediationFunctionBaseEffort;
    }

    /**
     * Sets the value of the remediationFunctionBaseEffort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemediationFunctionBaseEffort(String value) {
        this.remediationFunctionBaseEffort = value;
    }

    /**
     * Gets the value of the debtRemediationFunctionCoefficient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebtRemediationFunctionCoefficient() {
        return debtRemediationFunctionCoefficient;
    }

    /**
     * Sets the value of the debtRemediationFunctionCoefficient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebtRemediationFunctionCoefficient(String value) {
        this.debtRemediationFunctionCoefficient = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Gets the value of the ruleImplementation property.
     * 
     * @return
     *     possible object is
     *     {@link RuleImplementation }
     *     
     */
    public RuleImplementation getRuleImplementation() {
        return ruleImplementation;
    }

    /**
     * Sets the value of the ruleImplementation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RuleImplementation }
     *     
     */
    public void setRuleImplementation(RuleImplementation value) {
        this.ruleImplementation = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

}
