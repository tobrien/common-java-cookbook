project {
    modelVersion '4.0.0'
    parent {
        artifactId 'cjcook-parent'
        groupId 'com.discursive.cjcook'
        version '0.27-SNAPSHOT'
        relativePath '..'
    }
    artifactId 'cjcook-content'
    name 'Common Java Cookbook DocBook XML Content'
    description 'A Common Cookbook for Java'
    dependencies {
        dependency {
            groupId '${project.groupId}'
            artifactId 'cjcook-examples'
            version '${project.version}'
        }
    }
    build {
        sourceDirectory 'src/main/resources'
        resources {
            resource {
                filtering 'true'
                directory 'src/main/resources'
                includes {
                    include '*.xml'
                }
            }
            resource {
                filtering 'false'
                directory 'src/main/resources'
                excludes {
                    exclude '*.xml'
                }
            }
        }
        plugins {
            plugin {
                groupId 'org.codehaus.cjcook'
                artifactId 'docbook-plugin'
                version '1.3-SNAPSHOT'
                executions {
                    execution {
                        id 'validate-chapters'
                        phase 'test'
                        goals {
                            goal 'validate-chapter-ids'
                        }
                    }
                    execution {
                        id 'inject-examples'
                        phase 'process-classes'
                        goals {
                            goal 'inject-examples'
                        }
                    }
                    execution {
                        id 'wrappify'
                        goals {
                            goal 'wrappify'
                        }
                    }
                }
                configuration {
                    doctypeSystem 'http://www.discursive.com/docbook/xml/4.5/docbookx.dtd'
                }
            }
            plugin {
                artifactId 'maven-resources-plugin'
                version '2.3'
                configuration {
                    escapeString '\\'
                    encoding 'UTF-8'
                }
            }
        }
    }
    profiles {
        profile {
            id 'publish'
            distributionManagement {
                site {
                    id 'discursive-site'
                    name 'Discursive Site'
                    url 'scp://deployer@mars.discursive.com/var/www/html/www.discursive.com/books/cjcook/'
                }
            }
        }
        profile {
            id 'stage'
            distributionManagement {
                site {
                    id 'discursive-site'
                    name 'Discursive Site'
                    url 'scp://deployer@mars.discursive.com/var/www/html/www.discursive.com/books/cjcook-stage/'
                }
            }
        }
    }
}
