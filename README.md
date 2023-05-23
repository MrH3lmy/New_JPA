# Article API Collection

This collection provides a set of requests to interact with an Article API. The API allows you to manage articles and authors associated with them.

## Requests Description

The collection consists of the following requests:

1. **GET: Get Articles**

   - Description: Retrieves a list of all articles.
   - Endpoint: `http://localhost:8000/v1/articles`

2. **POST: Create New Article**

   - Description: Creates a new article.
   - Endpoint: `http://localhost:8000/v1/articles`
   - Body: JSON data containing the article details.
     ```json
     {
         "name": "ArticleName",
         "author": "authorName",
         "authorId": 1
     }
     ```

3. **GET: Get Single Article**

   - Description: Retrieves a single article by its ID.
   - Endpoint: `http://localhost:8000/v1/articles/1`

4. **DELETE: Delete Single Article**

   - Description: Deletes a single article by its ID.
   - Endpoint: `http://localhost:8000/v1/articles/1`

5. **PUT: Update Single Article**

   - Description: Updates a single article by its ID.
   - Endpoint: `http://localhost:8000/v1/articles/2`
   - Body: JSON data containing the updated article details.
     ```json
     {
         "id": 2,
         "name": "NewName",
         "author": "NewAuthor",
         "authorId": 1
     }
     ```

6. **POST: Create A New Author**

   - Description: Creates a new author.
   - Endpoint: `http://localhost:8080/authors`
   - Body: JSON data containing the author details.
     ```json
     {
         "name": "Ahmed ElShayeb"
     }
     ```

Note: Replace `localhost:8000` and `localhost:8080` with the appropriate domain and port of your Article API. Ensure that the request bodies and endpoints align with your specific API implementation.

## API Documentation

The API documentation is available in the [Postman Collection](https://www.postman.com/crimson-moon-466632/workspace/my-workspace/collection/21868696-7e015f20-ca16-4346-9f7c-57a445e59c9e?action=share&creator=21868696). It provides detailed information about each API endpoint, including request methods, parameters, and example responses.

## Technologies Used

- Spring boot 
- Java
- H2 Database
- Postman

## Contributing

Contributions are welcome! If you find any issues or want to add new features, feel free to submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

