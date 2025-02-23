const moviesContainer = document.getElementById('movies-container');
const searchInput = document.getElementById('search-input');
const searchButton = document.getElementById('search-button');
const nextButton = document.getElementById('next-button');
const reviewPopup = document.getElementById('review-popup');
const closePopup = document.querySelector('.close');
const submitReviewButton = document.getElementById('submit-review');
const ratingSelect = document.getElementById('rating');
const commentTextarea = document.getElementById('comment');

let movies = [];
let currentMovieIndex = 0;
const moviesPerPage = 3; // Number of movies to display per page

// Function to fetch movie details from the JSON file
async function fetchMovies() {
    try {
        const response = await fetch('movies.json');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        movies = await response.json();
        displayMovies();
    } catch (error) {
        console.error('Error fetching movie data:', error);
        moviesContainer.innerHTML = '<p>Error fetching movie data.</p>';
    }
}

// Function to display the current set of movies
function displayMovies() {
    moviesContainer.innerHTML = ''; // Clear previous results
    const endIndex = currentMovieIndex + moviesPerPage;
    const moviesToDisplay = movies.slice(currentMovieIndex, endIndex);

    moviesToDisplay.forEach(movie => {
        const movieCard = document.createElement('div');
        movieCard.classList.add('movie-card');
        movieCard.innerHTML = `
            <img src="${movie.poster}" alt="${movie.title}">
            <h3>${movie.title}</h3>
            <p>Rating: ${movie.rating}</p>
            <p>${movie.overview}</p>
            <button class="write-review" data-id="${movie.id}">Write Review</button>
            <div class="reviews-container" id="reviews-${movie.id}">
                ${movie.reviews.map(review => `
                    <div class="review">
                        <strong>${review.rating} Stars</strong>
                        <p>${review.comment}</p>
                    </div>
                `).join('')}
            </div>
        `;
        moviesContainer.appendChild(movieCard);

        // Add event listener for the review button
        const reviewButton = movieCard.querySelector('.write-review');
        reviewButton.addEventListener('click', () => openReviewPopup(movie.id));
    });

    // Disable the next button if there are no more movies to display
    nextButton.style.display = endIndex >= movies.length ? 'none' : 'block';
}

// Function to open the review popup
function openReviewPopup(movieId) {
    reviewPopup.style.display = 'block';
    submitReviewButton.setAttribute('data-movie-id', movieId);
}

// Function to close the review popup
closePopup.addEventListener('click', () => {
    reviewPopup.style.display = 'none';
    resetReviewForm();
});

// Function to reset the review form
function resetReviewForm() {
    ratingSelect.value = '1';
    commentTextarea.value = '';
}

// Function to handle review submission
submitReviewButton.addEventListener('click', () => {
    const movieId = submitReviewButton.getAttribute('data-movie-id');
    const rating = ratingSelect.value;
    const comment = commentTextarea.value;

    // Find the movie by ID and add the review
    const movie = movies.find(m => m.id === movieId);
    if (movie) {
        movie.reviews.push({ rating, comment }); // Add the review to the movie's reviews array

        // Display the new review in the movie card
        const reviewsContainer = document.getElementById(`reviews-${movieId}`);
        const newReview = document.createElement('div');
        newReview.classList.add('review');
        newReview.innerHTML = `
            <strong>${rating} Stars</strong>
            <p>${comment}</p>
        `;
        reviewsContainer.appendChild(newReview);
    }

    // Close the popup and reset the form
    reviewPopup.style.display = 'none';
    resetReviewForm();
});

// Event listener for the search button
searchButton.addEventListener('click', () => {
    const movieName = searchInput.value.trim().toLowerCase();
    const filteredMovies = movies.filter(movie => movie.title.toLowerCase().includes(movieName));
    currentMovieIndex = 0; // Reset to the first movie
    movies = filteredMovies; //
        // Update the movies array to the filtered results
        displayMovies();
    });
    
    // Event listener for the next button
    nextButton.addEventListener('click', () => {
        currentMovieIndex += moviesPerPage;
        if (currentMovieIndex >= movies.length) {
            currentMovieIndex = 0; // Loop back to the first movie
        }
        displayMovies();
    });
    
    // Fetch and display all movies on page load
    fetchMovies();