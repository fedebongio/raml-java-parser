/*
 * Copyright (c) MuleSoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.raml.parser.rules;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.raml.parser.builder.AbstractRamlTestCase;
import org.raml.parser.rule.ValidationResult;

public class SchemaRuleTestCase extends AbstractRamlTestCase
{

    @Test
    public void validJsonSchema()
    {
       validateRamlNoErrors("org/raml/schema/valid-json.yaml");
    }

    @Test
    public void validJsonSchemaGlobal()
    {
       validateRamlNoErrors("org/raml/schema/valid-json-global.yaml");
    }

    @Test
    public void validJsonSchemaGlobalTemplate()
    {
       validateRamlNoErrors("org/raml/schema/valid-json-global-template.yaml");
    }

    @Test
    public void invalidJsonSchema()
    {
        List<ValidationResult> validationResults = validateRaml("org/raml/schema/invalid-json.yaml");
        assertThat(validationResults.size(), is(1));
        assertThat(validationResults.get(0).getMessage(), containsString("invalid JSON schema"));
    }

    @Test
    public void invalidJsonSchemaGlobal()
    {
        List<ValidationResult> validationResults = validateRaml("org/raml/schema/invalid-json-global.yaml");
        assertThat(validationResults.size(), is(1));
        assertThat(validationResults.get(0).getMessage(), containsString("invalid JSON schema"));
    }

    @Test
    public void invalidJsonSchemaInclude()
    {
        List<ValidationResult> validationResults = validateRaml("org/raml/schema/invalid-json-include.yaml");
        assertThat(validationResults.size(), is(1));
        assertThat(validationResults.get(0).getMessage(), containsString("invalid JSON schema (org/raml/schema/invalid.json)"));
    }

    @Test
    public void invalidJsonSchemaGlobalTemplate()
    {
        List<ValidationResult> validationResults = validateRaml("org/raml/schema/invalid-json-global-template.yaml");
        assertThat(validationResults.size(), is(1));
        assertThat(validationResults.get(0).getMessage(), containsString("invalid JSON schema (put-leagues)"));
    }

    @Test
    public void validXmlSchema()
    {
        validateRamlNoErrors("org/raml/schema/valid-xml.yaml");
    }

    @Test
    public void invalidXmlSchema()
    {
        List<ValidationResult> validationResults = validateRaml("org/raml/schema/invalid-xml.yaml");
        assertThat(validationResults.size(), is(1));
        assertThat(validationResults.get(0).getMessage(), containsString("invalid XML schema"));
    }

    @Test
    public void validXmlSchemaGlobal()
    {
        validateRamlNoErrors("org/raml/schema/valid-xml-global.yaml");
    }

    @Test
    public void invalidXmlSchemaGlobal()
    {
        List<ValidationResult> validationResults = validateRaml("org/raml/schema/invalid-xml-global.yaml");
        assertThat(validationResults.size(), is(1));
        assertThat(validationResults.get(0).getMessage(), containsString("invalid XML schema"));
    }
}
