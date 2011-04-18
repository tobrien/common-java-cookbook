project {
    modelVersion '4.0.0'
    parent {
        artifactId 'cjcook-parent'
        groupId 'com.discursive.cjcook'
        version '0.27-SNAPSHOT'
        relativePath '..'
    }
    artifactId 'cjcook-pdf'
    name 'Common Java Cookbook PDF'
    description 'A Common Cookbook for Java'
    dependencies {
        dependency {
            groupId '${project.groupId}'
            artifactId 'cjcook-content'
            version '${project.version}'
        }
    }
    build {
        resources {
            resource {
                filtering 'true'
                directory 'src/main/resources'
                includes {
                    include 'fopdf.xsl'
                }
            }
            resource {
                filtering 'false'
                directory 'src/main/resources'
                excludes {
                    exclude 'fopdf.xsl'
                }
            }
        }
        plugins {
            plugin {
                artifactId 'maven-resources-plugin'
                version '2.3'
                configuration {
                    escapeString '\\'
                    encoding 'UTF-8'
                }
            }
            plugin {
                groupId 'org.codehaus.cjcook'
                artifactId 'docbook-plugin'
                version '1.0'
            }
            plugin {
                groupId 'org.codehaus.cjcook'
                artifactId 'pdf-plugin'
                version '1.0'
                executions {
                    execution {
                        id 'concat-pdfs'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-complete.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-book-cover.pdf'
                                pdf '${basedir}/target/book-cjcook.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-app-infra'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-app-infra.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-app-infra-cover.pdf'
                                pdf '${basedir}/target/chapter-app-infra.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-beans'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-beans.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-beans-cover.pdf'
                                pdf '${basedir}/target/chapter-beans.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-collections'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-collections.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-collections-cover.pdf'
                                pdf '${basedir}/target/chapter-collections.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-functors'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-functors.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-functors-cover.pdf'
                                pdf '${basedir}/target/chapter-functors.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-http-webdav'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-http-webdav.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-http-webdav-cover.pdf'
                                pdf '${basedir}/target/chapter-http-webdav.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-io-network'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-io-network.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-io-network-cover.pdf'
                                pdf '${basedir}/target/chapter-io-network.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-json'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-json.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-json-cover.pdf'
                                pdf '${basedir}/target/chapter-json.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-lang'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-lang.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-lang-cover.pdf'
                                pdf '${basedir}/target/chapter-lang.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-manipulate-text'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-manipulate-text.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-manipulate-text-cover.pdf'
                                pdf '${basedir}/target/chapter-manipulate-text.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-math'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-math.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-math-cover.pdf'
                                pdf '${basedir}/target/chapter-math.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-proto'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-proto.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-proto-cover.pdf'
                                pdf '${basedir}/target/chapter-proto.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-filtering'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-searching-filtering.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-searching-filtering-cover.pdf'
                                pdf '${basedir}/target/chapter-searching-filtering.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-templating'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-templating.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-templating-cover.pdf'
                                pdf '${basedir}/target/chapter-templating.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-xml'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-xml.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-xml-cover.pdf'
                                pdf '${basedir}/target/chapter-xml.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-guava-io'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-guava-io.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-guava-io-cover.pdf'
                                pdf '${basedir}/target/chapter-guava-io.pdf'
                            }
                        }
                    }
                    execution {
                        id 'concat-pdf-guava-collect'
                        phase 'process-classes'
                        goals {
                            goal 'concatenate'
                        }
                        configuration {
                            outputDir '${basedir}/target'
                            outputFilename 'cjcook-chapter-guava-collect.pdf'
                            pdfs {
                                pdf '${basedir}/src/main/resources/cjcook-guava-collect-cover.pdf'
                                pdf '${basedir}/target/chapter-guava-collect.pdf'
                            }
                        }
                    }
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
            plugin {
                groupId 'com.agilejava.docbkx'
                artifactId 'docbkx-fop-support'
                version '2.0.9'
                executions {
                    execution {
                        phase 'generate-resources'
                        goals {
                            goal 'generate'
                        }
                        configuration {
                            ansi 'true'
                        }
                    }
                }
            }
            plugin {
                groupId 'com.agilejava.docbkx'
                artifactId 'docbkx-maven-plugin'
                version '2.0.9'
                executions {
                    execution {
                        id 'generate-pdf'
                        phase 'compile'
                        goals {
                            goal 'generate-pdf'
                        }
                    }
                }
                dependencies {
                    dependency {
                        groupId 'docbook'
                        artifactId 'docbook-xml'
                        version '4.5'
                    }
                    dependency {
                        groupId 'org.apache.fop'
                        artifactId 'fop-pdf-images'
                        version '1.3'
                    }
                    dependency {
                        groupId 'org.apache.fop'
                        artifactId 'fop-pdf-images-res'
                        version '1.3'
                        classifier 'res'
                    }
                    dependency {
                        groupId 'pdfbox'
                        artifactId 'pdfbox'
                        version '0.7.4-dev'
                        classifier 'dev'
                    }
                }
                configuration {
                    sourceDirectory '${basedir}/target/docbook'
                    targetDirectory '${basedir}/target'
                    includes 'book-cjcook.xml,chapter-*.xml'
                    xincludeSupported 'true'
                    imgSrcPath '${basedir}/target/docbook/'
                    foCustomization '${basedir}/target/classes/fopdf.xsl'
                    bodyFontFamily 'TimesNewRoman'
                    monospaceFontFamily 'Courier'
                    titleFontFamily 'ArialBold'
                    fonts {
                        font {
                            name 'Arial'
                            style 'normal'
                            weight 'normal'
                            embedFile '${basedir}/src/fonts/Arial.ttf'
                            metricsFile '${basedir}/target/fonts/Arial-metrics.xml'
                        }
                        font {
                            name 'ArialBold'
                            style 'normal'
                            weight 'normal'
                            embedFile '${basedir}/src/fonts/ArialBold.ttf'
                            metricsFile '${basedir}/target/fonts/ArialBold-metrics.xml'
                        }
                        font {
                            name 'Courier'
                            style 'normal'
                            weight 'normal'
                            embedFile '${basedir}/src/fonts/Courier.ttf'
                            metricsFile '${basedir}/target/fonts/Courier-metrics.xml'
                        }
                        font {
                            name 'Courier'
                            style 'normal'
                            weight 'bold'
                            embedFile '${basedir}/src/fonts/Courier-Bold.ttf'
                            metricsFile '${basedir}/target/fonts/Courier-Bold-metrics.xml'
                        }
                        font {
                            name 'Courier'
                            style 'italic'
                            weight 'normal'
                            embedFile '${basedir}/src/fonts/Courier-Oblique.ttf'
                            metricsFile '${basedir}/target/fonts/Courier-Oblique-metrics.xml'
                        }
                        font {
                            name 'TimesNewRoman'
                            style 'normal'
                            weight 'normal'
                            embedFile '${basedir}/src/fonts/TimesNewRoman.ttf'
                            metricsFile '${basedir}/target/fonts/TimesNewRoman-metrics.xml'
                        }
                    }
                }
            }
            plugin {
                artifactId 'maven-dependency-plugin'
                executions {
                    execution {
                        id 'unpack'
                        phase 'generate-sources'
                        goals {
                            goal 'unpack'
                        }
                        configuration {
                            artifactItems {
                                artifactItem {
                                    groupId '${project.groupId}'
                                    artifactId 'cjcook-content'
                                    version '${project.version}'
                                }
                            }
                            outputDirectory '${basedir}/target/docbook'
                        }
                    }
                }
            }
            plugin {
                artifactId 'maven-install-plugin'
                executions {
                    execution {
                        id 'install-book-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-complete.pdf'
                            artifactId '${artifactId}'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-app-infra-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-app-infra.pdf'
                            artifactId 'cjcook-chapter-app-infra'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-beans-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-beans.pdf'
                            artifactId 'cjcook-chapter-beans'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-collections-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-collections.pdf'
                            artifactId 'cjcook-chapter-collections'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-functors-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-functors.pdf'
                            artifactId 'cjcook-chapter-functors'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-http-webdav-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-http-webdav.pdf'
                            artifactId 'cjcook-chapter-http-webdav'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-io-network-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-io-network.pdf'
                            artifactId 'cjcook-chapter-io-network'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-lang-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-lang.pdf'
                            artifactId 'cjcook-chapter-lang'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-json-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-json.pdf'
                            artifactId 'cjcook-chapter-json'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-manipulate-text-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-manipulate-text.pdf'
                            artifactId 'cjcook-chapter-manipulate-text'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-math-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-math.pdf'
                            artifactId 'cjcook-chapter-math'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-proto-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-proto.pdf'
                            artifactId 'cjcook-chapter-proto'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-searching-filtering-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-searching-filtering.pdf'
                            artifactId 'cjcook-chapter-searching-filtering'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-templating-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-templating.pdf'
                            artifactId 'cjcook-chapter-templating'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-xml-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-xml.pdf'
                            artifactId 'cjcook-chapter-xml'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-guava-io-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-guava-io.pdf'
                            artifactId 'cjcook-chapter-guava-io'
                            packaging 'pdf'
                        }
                    }
                    execution {
                        id 'install-chapter-guava-collect-pdf'
                        phase 'install'
                        goals {
                            goal 'install-file'
                        }
                        configuration {
                            file '${basedir}/target/cjcook-chapter-guava-collect.pdf'
                            artifactId 'cjcook-chapter-guava-collect'
                            packaging 'pdf'
                        }
                    }
                }
                configuration {
                    groupId '${groupId}'
                    version '${version}'
                }
            }
        }
    }
}
