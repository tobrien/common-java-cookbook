project {
    modelVersion '4.0.0'
    parent {
        artifactId 'cjcook-parent'
        groupId 'com.discursive.cjcook'
        version '0.27-SNAPSHOT'
        relativePath '..'
    }
    artifactId 'cjcook-examples'
    name 'Common Java Cookbook Examples'
    description 'Examples which accompany a Common Cookbook for Java'
    dependencies {
        dependency {
            groupId 'commons-beanutils'
            artifactId 'commons-beanutils'
            version '1.8.0'
        }
        dependency {
            groupId 'commons-collections'
            artifactId 'commons-collections'
            version '3.2.1'
        }
        dependency {
            groupId 'commons-digester'
            artifactId 'commons-digester'
            version '1.8'
        }
        dependency {
            groupId 'commons-httpclient'
            artifactId 'commons-httpclient'
            version '3.1'
        }
        dependency {
            groupId 'commons-jexl'
            artifactId 'commons-jexl'
            version '1.1'
        }
        dependency {
            groupId 'commons-jxpath'
            artifactId 'commons-jxpath'
            version '1.3'
        }
        dependency {
            groupId 'commons-lang'
            artifactId 'commons-lang'
            version '2.4'
        }
        dependency {
            groupId 'commons-logging'
            artifactId 'commons-logging'
            version '1.0.4'
        }
        dependency {
            groupId 'log4j'
            artifactId 'log4j'
            version '1.2.15'
            exclusions {
                exclusion {
                    artifactId 'jms'
                    groupId 'javax.jms'
                }
                exclusion {
                    artifactId 'jmxtools'
                    groupId 'com.sun.jdmk'
                }
                exclusion {
                    artifactId 'jmxri'
                    groupId 'com.sun.jmx'
                }
            }
        }
        dependency {
            groupId 'commons-cli'
            artifactId 'commons-cli'
            version '1.1'
        }
        dependency {
            groupId 'commons-configuration'
            artifactId 'commons-configuration'
            version '1.6'
        }
        dependency {
            groupId 'commons-io'
            artifactId 'commons-io'
            version '1.4'
        }
        dependency {
            groupId 'commons-math'
            artifactId 'commons-math'
            version '1.2'
        }
        dependency {
            groupId 'commons-net'
            artifactId 'commons-net'
            version '2.2'
        }
        dependency {
            groupId 'org.apache.velocity'
            artifactId 'velocity'
            version '1.6.1'
        }
        dependency {
            groupId 'slide'
            artifactId 'slide-webdavlib'
            version '2.1'
        }
        dependency {
            groupId 'org.freemarker'
            artifactId 'freemarker'
            version '2.3.15'
        }
        dependency {
            groupId 'commons-betwixt'
            artifactId 'commons-betwixt'
            version '0.8'
        }
        dependency {
            groupId 'org.apache.lucene'
            artifactId 'lucene-core'
            version '1.9.1'
        }
        dependency {
            groupId 'net.sf.json-lib'
            artifactId 'json-lib'
            version '2.3'
            classifier 'jdk15'
        }
        dependency {
            groupId 'xom'
            artifactId 'xom'
            version '1.1'
            scope 'compile'
        }
        dependency {
            groupId 'com.google.protobuf'
            artifactId 'protobuf-java'
            version '2.3.0'
            scope 'compile'
        }
        dependency {
            groupId 'com.google.guava'
            artifactId 'guava'
            version '${googleguava.version}'
            scope 'compile'
        }
    }
    build {
        plugins {
            plugin {
                artifactId 'maven-assembly-plugin'
                executions {
                    execution {
                        id 'make-assembly'
                        phase 'package'
                        goals {
                            goal 'single'
                        }
                    }
                }
                configuration {
                    descriptorRefs {
                        descriptorRef 'src'
                        descriptorRef 'jar-with-dependencies'
                    }
                }
            }
            plugin {
                artifactId 'maven-compiler-plugin'
                configuration {
                    source '1.6'
                    target '1.6'
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
                    url 'scp://deployer@mars.discursive.com/var/www/html/www.discursive.com/books/cjcook/examples/'
                }
            }
        }
        profile {
            id 'stage'
            distributionManagement {
                site {
                    id 'discursive-site'
                    name 'Discursive Site'
                    url 'scp://deployer@mars.discursive.com/var/www/html/www.discursive.com/books/cjcook-stage/examples/'
                }
            }
        }
    }
}
