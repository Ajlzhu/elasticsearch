全文检索：

数据结构：

    数据总体分为两种：
    	结构化数据：
    		有固定格式或有限长度的数据
    		如：数据库中的数据、元数据(文件、文件夹...)等
    	非结构化数据：
    		不定长或无固定格式的数据
    		如：邮件，word文档等磁盘上的文件
    		
    数据的搜索方式：
    	结构化数据：
    		数据库中数据通过sql语句可以搜索
    		元数据(windows中的)通过windows提供的搜索栏进行搜索
    
    	非结构化数据：
    		顺序扫描法：
    			拿到搜索的关键字,去文档中,逐字匹配,直到找到和关键字一致的内容为止
    			优点: 如果文档中存在要找的关键字就一定能找到想要的内容
    			缺点: 慢, 效率低
    			
    		全文检索：Full-text Search
    			先建立索引，再对索引进行搜索的过程就叫全文检索
    			如：字典(有拼音和部首索引)
    				相当于字典,分为目录和正文两部分
    				查询的时候通过先查目录,然后通过目录上标注的页数去正文页查找需要的内容
    				
    			分词：
    				去掉停用词(a, an, the ,的, 地, 得, 啊, 嗯 ,呵呵)
    				因为搜索的时候搜索这些词没有意义,将句子拆分成词,去掉标点符号和空格
    			
    			优点: 搜索速度快
    			缺点: 创建索引需要占用磁盘空间(用空间换时间)
    
            	全文检索应用场景：
            		对于数据量大、数据结构不固定的数据可采用全文检索方式搜索
            		如：百度、Google等搜索引擎、论坛站内搜索、电商网站、站内搜索等

Lunece：

    Lucene：全文检索
    	apache的一个开放源代码的全文检索引擎工具包
    	它是可以创建全文检索引擎系统的一堆jar包
    		可以使用它来构建全文检索引擎系统,但是它不能独立运
    		
    全文检索引擎系统：
    	放在tomcat下可以独立运行,对外提供全文检索服务
    	
    Lucene应用领域：
    	1.互联网全文检索引擎(比如百度,  谷歌,  必应)
    	2.站内全文检索引擎(淘宝, 京东搜索功能)
    	3.优化数据库查询(因为数据库中使用like关键字是全表扫描也就是顺序扫描算法,查询慢)
    	
    常见的基于Lunece开源搜索引擎解决方案：
    	Solr:Java编写、运行在Servlet容器的一个独立的全文搜索服务器
    	ElasticSearch：java编写、实时的分布式搜索和分析引擎...
    	Katta：基于Lucene的，支持分布式，可扩展，具有容错功能，准实时的搜索方案
    	Hadoop contrib/index：Map/Reduce 模式的，分布式建索引方案，可以跟 Katta 配合使用
    	LinkedIn 的开源方案：
    		基于Lucene的一系列解决方案，包括：
                准实时搜索 zoie ，facet 
                搜索实现 bobo 
                机器学习算法 decomposer 
                摘要存储库 krati 
                数据库模式包装 sensei 等等
    	Lucandra：基于Lucene，索引存在 cassandra 数据库中
    	HBasene：基于Lucene，索引存在 HBase 数据库中

Solr：

    Solr全文检索引擎：
    	Apache下的一个顶级开源项目
    	采用Java开发，基于Lucene的全文搜索服务器
    
    	特点：
    		1.Solr提供了比Lucene更为丰富的查询语言
    		2.可配置、可扩展，并对索引、搜索性能进行了优化
    		3.Solr可以独立运行，运行在Jetty、Tomcat等这些Servlet容器中
    
    Solr与Lucene的区别：
    	Lucene是一个开放源代码的全文检索引擎工具包，它不是一个完整的全文检索引擎
    	Solr是一个搜索引擎服务，可以独立运行

elasticsearch：

    ElasticSearch是全文检索：
    	采用java开发，基于Lucene的全文搜索服务器
    	特点：
            分布式多用户能力的全文搜索引擎
            基于RESTful web接口
            高度可扩展的开源全文搜索和分析引擎
            快速地、近实时地对大数据进行存储、搜索和分析
            用来支撑有复杂的数据搜索需求的企业级应用
    	简单来说就是：
    		分布式、高可用、多类型、多API、面向文档
    		异步写入、近实时、基于lucene、Apache协议
    核心概念：
    	近实时
    	集群	节点
    	索引	类型	文档
    	分片	副本
    
    ElasticSearch与Solr的区别：
    	Solr 利用 Zookeeper 进行分布式管理，而 Elasticsearch 自身带有分布式协调管理功能
    	Solr 支持更多格式的数据，而 Elasticsearch 仅支持json文件格式
    	Solr 官方提供的功能更多，而 Elasticsearch 本身更注重于核心功能，高级功能多有第三方插件提供
    	Solr 在传统的搜索应用中表现好于 Elasticsearch，但在处理实时搜索应用时效率明显低于 Elasticsearch
    	
    	总的来说：Solr是传统搜索应用的有力解决方案，但Elasticsearch更适用于新兴的实时搜索应用

elasticsearch配置：

    下载安装：
    	1.下载地址：https://www.elastic.co/downloads/elasticsearch
    	2.解压压缩包到相应目录
    	
    elasticsearch启动：
    	进入elasticsearch的bin目录下，双击elasticsearch.bat即可

spring boot集成elasticsearch：

    环境配置：
    	spring data ElasticSearch3.0.9RELEASE依赖于(elasticsearch5.6.10)
    	JNA4.5.2
    整合步骤：
    	1.添加依赖：
    		compile('org.springframework.boot:spring-boot-starter-web')
            compile ('org.springframework.data:spring-data-elasticsearch')
            compile('org.springframework.boot:spring-boot-starter-data-jpa')
            compile('net.java.dev.jna:jna:4.5.2')
            runtime('com.h2database:h2:1.4.193')
            testCompile('org.springframework.boot:spring-boot-starter-test')
    	2.修改application.properties：
    		#ElasticSearch 服务地址
            spring.data.elasticsearch.cluster-nodes=localhost:9300
            #设置链接超时时间
            spring.data.elasticsearch.properties.transport.tcp.connect_timeout=120s
    	3.编码实现：
    		实体：EsBlog
    			类上添加Document注解
    			主键id添加@Id注解
    			protected修饰无参构造方法
    			
    			@Document(indexName = "blog",type = "blog")
                public class EsBlog implements Serializable {
    
                    private static final long serialVersionUID = 473527900606831370L;
    
                    @Id
                    private String id;
                    private String title;
                    private String summary;
                    private String content;
    
                    protected EsBlog() {
                    }
    
                    public EsBlog(String title, String summary, String content) {
                        this.title = title;
                        this.summary = summary;
                        this.content = content;
                    }
                 	//省略geeter/setter/toString方法
    			}
    		资源库：EsBlogRepository
    			public interface EsBlogRepository
                extends ElasticsearchRepository<EsBlog,String> {
                /**
                 * 分页查询出标题包含title或摘要包含summary或内容包含content的博客并去重
                 * @param title 标题
                 * @param summary   摘要
                 * @param content   内容
                 * @return Page<EsBlog>
                 */
                Page<EsBlog> findDistinctEsBlogByTitleContainingOr
                SummaryContainingOrContentContaining(String title,
                String summary, String content, Pageable pageable);
            }
    		控制器：EsBlogController
    			@RestController
                @RequestMapping("/blogs")
                public class EsBlogController {
    
                    @Autowired
                    private EsBlogRepository esBlogRepository;
                    @RequestMapping("/list")
                    public List<EsBlog>  list(...){...}
                }
    	4.启动elasticsearch
    	5.编写测试用例：
    		1..新建与EsBlogRepository.java具有相同目录结构的EsBlogRepositoryTest.java
                \src\main\java\com\li\blog\repository\EsBlogRepository.java
                \src\test\java\com\li\blog\repository\EsBlogRepositoryTest.java
    		2.在类上添加相关注解
    			@RunWith(SpringRunner.class)
    			@SpringBootTest
            3.初始化数据：
            	@Before：测试方法执行前执行添加了该注解的方法
            	所以项目启动时，需先通过测试用例，所以项目启动后数据已经初始化了
            	@Before
        		public void initRepositoryData(){...}
    		4.编写测试方法：
    			@Test
        		public void findDistinctEsBlogByTitleContainingOr
        		SummaryContainingOrContentContaining() {...}
    	6.启动项目：
    		访问项目地址：localhost:8080/blogs/list
    		参数：
    			title:1
                summary:GFM
                content:Thymeleaf
                pageIndex:0
                pageSize:10


