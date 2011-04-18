project {
    modelVersion '4.0.0'
    parent {
        artifactId 'cjcook-parent'
        groupId 'com.discursive.cjcook'
        version '0.27-SNAPSHOT'
        relativePath '..'
    }
    artifactId 'cjcook-site'
    name 'Common Java Cookbook Website'
    description 'A Common Cookbook for Java'
    dependencies {
        dependency {
            groupId '${project.groupId}'
            artifactId 'cjcook-pdf'
            version '${project.version}'
        }
        dependency {
            groupId '${project.groupId}'
            artifactId 'cjcook-html'
            version '${project.version}'
        }
        dependency {
            groupId '${project.groupId}'
            artifactId 'cjcook-single-html'
            version '${project.version}'
        }
        dependency {
            groupId '${project.groupId}'
            artifactId 'cjcook-examples'
            version '${project.version}'
        }
    }
    build {
        plugins {
            plugin {
                artifactId 'maven-release-plugin'
                version '2.0-beta-9'
                configuration {
                    goals 'clean install site-deploy'
                }
            }
            plugin {
                artifactId 'maven-dependency-plugin'
                executions {
                    execution {
                        id 'unpack-html'
                        phase 'site'
                        goals {
                            goal 'unpack'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-html'
                                    version '${project.version}'
                                }
                            }
                            outputDirectory '${basedir}/target/site/reference'
                        }
                    }
                    execution {
                        id 'copy-examples'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-examples'
                                    version '${project.version}'
                                    classifier 'src'
                                    type 'zip'
                                }
                            }
                            outputDirectory '${basedir}/target/site/'
                        }
                    }
                    execution {
                        id 'copy-html'
                        phase 'site'
                        goals {
                            goal 'unpack'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-html'
                                    version '${project.version}'
                                }
                            }
                            outputDirectory '${basedir}/target/site/reference'
                        }
                    }
                    execution {
                        id 'copy-pdf'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-pdf'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-app-infra'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-app-infra'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-beans'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-beans'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-collections'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-collections'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-functors'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-functors'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-httpd-webdav'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-http-webdav'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-io-network'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-io-network'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-json'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-json'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-lang'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-lang'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-manipulate-text'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-manipulate-text'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-math'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-math'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-proto'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-proto'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-searching-filtering'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-searching-filtering'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-templating'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-templating'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-xml'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-xml'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-guava-io'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-guava-io'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-pdf-guava-collect'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-chapter-guava-collect'
                                    version '${project.version}'
                                    type 'pdf'
                                }
                            }
                            outputDirectory '${basedir}/target/site/pdf'
                        }
                    }
                    execution {
                        id 'copy-epub'
                        phase 'site'
                        goals {
                            goal 'copy'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-epub'
                                    version '${project.version}'
                                    type 'epub'
                                }
                            }
                            outputDirectory '${basedir}/target/site/epub'
                        }
                    }
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
                    url 'scp://deployer@www.discursive.com/var/lib/books/cjcook/'
                }
            }
        }
        profile {
            id 'stage'
            distributionManagement {
                site {
                    id 'discursive-site'
                    name 'Discursive Site'
                    url 'scp://deployer@www.discursive.com/var/lib/books/cjcook-stage/'
                }
            }
        }
    }
}
