<h2>Update Book</h2>
<form method="post" action="${pageContext.request.contextPath}/book/update">
    <input type="hidden" id="id" name="id" value="${book.id}">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${book.title}" required><br>
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" value="${book.author}" required><br>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" value="${book.price}" step="0.01" min="0" required><br>
    <button type="submit">Update Book</button>
</form>
