/*
 * Copyright (C) 2001-2024 Food and Agriculture Organization of the
 * United Nations (FAO-UN), United Nations World Food Programme (WFP)
 * and United Nations Environment Programme (UNEP)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 *
 * Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
 * Rome - Italy. email: geonetwork@osgeo.org
 */

package org.fao.geonet.domain;

import org.fao.geonet.entitylistener.DoiServerEntityListenerManager;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Doiservers")
@Cacheable
@Access(AccessType.PROPERTY)
@EntityListeners(DoiServerEntityListenerManager.class)
@SequenceGenerator(name = DoiServer.ID_SEQ_NAME, initialValue = 100, allocationSize = 1)
public class DoiServer extends GeonetEntity {
    static final String ID_SEQ_NAME = "doiserver_id_seq";

    private int id;
    private String name;
    private String description;
    private String url;
    private String username;
    private String password;
    private String landingPageTemplate;
    private String publicUrl;
    private String pattern = "{{uuid}}";
    private String prefix;
    private Set<Group> publicationGroups = new HashSet<>();

    /**
     * Get the id of the DOI server. <p> This is autogenerated and when a new DOI server is created
     * the DOI server will be assigned a new value. </p>
     *
     * @return the id of the DOI server.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQ_NAME)
    @Column(nullable = false)
    public int getId() {
        return id;
    }

    /**
     * Set the id of the DOI server. <p> If you want to update an existing DOI server then you should
     * set this id to the DOI server you want to update and set the other values to the desired
     * values. </p>
     *
     * @param id the id of the group.
     * @return this DOI server object
     */
    public DoiServer setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Get the basic/default name of the DOI server. This is non-translated and can be used to look
     * up the DOI server like an id can. <p> This is a required property. <p> There is a max length
     * to the name allowed. See the annotation for the length value. </p>
     *
     * @return DOI server name
     */
    @Column(nullable = false, length = 32)
    public String getName() {
        return name;
    }

    /**
     * Set the basic/default name of the DOI server. This is non-translated and can be used to look
     * up the DOI server like an id can. <p> This is a required property. <p> There is a max length
     * to the name allowed. See the annotation on {@link #getName()} for the length value. </p>
     */
    public DoiServer setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get a description of the DOI server.
     *
     * @return the description.
     */
    @Column(length = 255)
    public String getDescription() {
        return description;
    }

    /**
     * Set the DOI server description.
     *
     * @param description the description.
     * @return this DOI server object.
     */
    public DoiServer setDescription(String description) {
        this.description = description;
        return this;
    }


    /**
     * Get the API URL for the DOI server.
     *
     * @return the DOI server API URL.
     */
    @Column(nullable = false, length = 255)
    public String getUrl() {
        return url;
    }

    /**
     * Set the REST API configuration URL for the DOI server.
     *
     * @param url the server URL.
     * @return this DOI server object.
     */
    public DoiServer setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get the username to use for connecting to the DOI server.
     *
     * @return the username.
     */
    @Column(length = 128)
    public String getUsername() {
        return username;
    }

    public DoiServer setUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Get the password to use for connecting to the DOI server.
     *
     * @return the password.
     */
    @Column(length = 128)
    @Type(type="encryptedString")
    public String getPassword() {
        return password;
    }

    public DoiServer setPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Set the DOI landing page URL template.
     *
     * @param landingPageTemplate the landing page URL template.
     * @return this DOI server object.
     */
    public DoiServer setLandingPageTemplate(String landingPageTemplate) {
        this.landingPageTemplate = landingPageTemplate;
        return this;
    }

    /**
     * Get the DOI landing page URL template.
     *
     * @return the landing page URL template.
     */
    @Column(nullable = false, length = 255)
    public String getLandingPageTemplate() {
        return landingPageTemplate;
    }

    /**
     * Set the DOI URL prefix.
     *
     * @param publicUrl the URL prefix.
     * @return this DOI server object.
     */
    public DoiServer setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
        return this;
    }

    /**
     * Get the DOI URL prefix.
     *
     * @return the URL prefix.
     */
    @Column(nullable = false, length = 255)
    public String getPublicUrl() {
        return publicUrl;
    }

    /**
     * Set the DOI identifier pattern.
     *
     * @param pattern the identifier pattern.
     * @return this DOI server object.
     */
    public DoiServer setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    /**
     * Get the DOI identifier pattern.
     *
     * @return the identifier pattern.
     */
    @Column(nullable = false, length = 255)
    public String getPattern() {
        return pattern;
    }


    /**
     * Set the DOI prefix.
     *
     * @param prefix    the DOI prefix.
     * @return          this DOI server object.
     */
    public DoiServer setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Get the DOI prefix.
     *
     * @return the DOI prefix.
     */
    @Column(nullable = false, length = 15)
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the groups which metadata should be published to the DOI server.
     *
     * @param publicationGroups     Publication groups.
     * @return
     */
    public void setPublicationGroups(Set<Group> publicationGroups) {
        this.publicationGroups = publicationGroups;
    }

    /**
     * Get the groups which metadata is published to the DOI server.
     *
     * @return  Publication groups.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "doiservers_group",
        joinColumns = @JoinColumn(name = "doiserver_id"),
        inverseJoinColumns = @JoinColumn(name = "group_id"))
    public Set<Group> getPublicationGroups() {
        return publicationGroups;
    }
}