# Application Code Automation using ChatGPT AI

>Version 1

This project is an application code generator using the ChatGPT AI services. Here you will find.
1) Application Code Generator Engine.
2) Demo Spring Boot Data Application.
<br/><br/>

## Application Code Generator Engine
The standalone Bootstrap class is located in the 
- 'src/main/java/com/java/aadityadesigners/_chatgpt/ProjectFilesGenerator.java' class.

It used the templates to construct the appropriate commands used to call the ChatGPT API. Then the code response is dumped to the
- 'src/main/resources/templates/_staging' folder. 

From here the developer can edit the code to fit as per the requirement.
<br/><br/>

### | Templates |
They play very important role to construct the command for the ChatGPT AI since there is a strict limitation on the length of words to be sent to the API.
<br/><br/>

>Commands

The commands for creating different types of project modules are contained in the below json file. It contains command key with the requirement request on a high level.
- src/main/resources/templates/chatgpt-commands.json
```json
{
    "entity": "Using latest Spring Boot Data JPA with Lombok and Javax validations, please show the Java code for the following requirement as defined.",
    "repository": "Using previously created components and latest Spring Boot Data JPA (without using EntityManager) with Exception Handling, please show the Repository Java code for the following requirement as defined.",
    "dto": "Using Lombok and Javax validations, please show the equivalent Java Dto code for the following requirement as defined.",
    "service": "Using previously created components and latest Spring Boot with Exception Handling and Transactional Support, please show the Service Java code for the following requirement as defined.",
    "controller": "Using previously created components and latest Spring Boot REST API, please show the equivalent Java Controller code for the following requirement as defined."
}
```
<br/>

>Project Configurations

The exact technical code requirements (per project basis) is defined in a json file and then it is combined with the command request to complete the request to be send to the ChatGPT API. 

NOTE: It can be observed here that in the "operationDetails" tag, you can define your business logic in words which the ChatGPT AI will convert it to relevant code automatically.

```json
{
    "basePackage": "com.java.aadityadesigners.productservice",
    "entity": [{
        "name": "CategoryEntity",
        "table": "Category",
        "attributes": [
            {"name": "id", "type": "Long"},
            {"name": "name", "type": "String"}
        ]}...
    ],
    "repository": [{
        "name": "ProductRepository",
        "method": [
            {
                "name": "findProductsByCategory",
                "operationDetails": "Find the list of ProductEntity by CategoryEntity"
            },
            {
                "name": "findProductsCountByCategory",
                "operationDetails": "Find the total count of ProductEntity by CategoryEntity."                    
            }...             
        ]}
    ],
    "service": [{
        "name": "ProductService",
        "method": [
            {
                "name": "findProductsByCategory",
                "operationDetails": "Find the list of ProductDto by CategoryDto using ProductRepository. Use Dto to Entity Converter utility."
            }           
        ]}...
    ],  
    "controller": [
        {
            "name": "ProductController",
            "method": [
                {
                    "name": "findProductsByCategory",
                    "operationDetails": "Find the list of ProductDto by CategoryDto using ProductService."
                }...
            ]
        }
    ]      

```


