fetch('http://localhost:8080/movie/allMovies/desc')
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(movie => {
            const rank = `<p>${movie.rank}</p>`;
            const title = `<p><a href='../../../allMoviesById/allMoviesById.html?index=${movie.rank}'">${movie.movieTitle}</a></p>`;
            let score;
            if ((movie.score > 8 && movie.score < 9) || (movie.score > 9 && movie.score < 10)) score = `<p>${movie.score}</p>`;
            else score = `<p>${movie.score}.0</p>`;
            const length = `<p>${movie.movieHours}h ${movie.movieMinutes}m</p>`;
            const year = `<p>${movie.releaseYear}</p>`;
            const rating = `<p>${movie.rating}</p>`;
            let boxOffice;
            if (movie.boxOffice >= 1 && movie.boxOffice < 1000) boxOffice = `<p>$${movie.boxOffice} Million</p>`;
            else if (movie.boxOffice >= 1000) boxOffice = `<p>$${movie.boxOffice/1000} Billion</p>`;
            else if (movie.boxOffice < 0) boxOffice = `<p>No Info</p>`
            else boxOffice = `<p>$${Math.floor(movie.boxOffice*1000)},${Math.floor((movie.boxOffice*1000000)%1000)}</p>`;
            document.querySelector('#movieRank').insertAdjacentHTML('beforeend', rank);
            document.querySelector('#movieTitle').insertAdjacentHTML('beforeend', title);
            document.querySelector('#movieScore').insertAdjacentHTML('beforeend', score);
            document.querySelector('#movieLength').insertAdjacentHTML('beforeend', length);
            document.querySelector('#movieYear').insertAdjacentHTML('beforeend', year);
            document.querySelector('#movieRating').insertAdjacentHTML('beforeend', rating);
            document.querySelector('#movieBoxOffice').insertAdjacentHTML('beforeend', boxOffice);
        })
    })
    .catch(error => console.log(error));

const userCardTemplate = document.querySelector("[data-user-template]");
const userCardContainer = document.querySelector("[data-user-cards-container]");
const searchInput = document.querySelector("[data-search]");
let movies = [];
searchInput.addEventListener("input", (e) => {
    const value = e.target.value.trim().toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
    let count = 0;
    movies.forEach(movie => {
        const title = movie.title.toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
        let isVisible = title.includes(value);
        movie.element.classList.toggle("hide", !isVisible);
        movie.element.classList.toggle("show", isVisible);
        if (isVisible) {
            count++;
        }
        if (value === "") {
            isVisible = !isVisible;
            movie.element.classList.toggle("hide", !isVisible);
            movie.element.classList.toggle("show", isVisible);
        }
        if (count > 5) {
            movie.element.classList.add("hide");
            movie.element.classList.remove("show");
        }
        document.addEventListener('click', function (event) {
            if (!movie.element.contains(event.target) && event.target !== searchInput) {
                movie.element.classList.add("hide");
                movie.element.classList.remove("show");
            }
        })
    });
});

searchInput.addEventListener('click', function () {
    const value = searchInput.value.trim().toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
    let count = 0;
    movies.forEach(movie => {
        const title = movie.title.toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
        const isVisible = title.includes(value);
        movie.element.classList.toggle("hide", !isVisible);
        movie.element.classList.toggle("show", isVisible);
        if (isVisible) {
            count++;
        }
        if (count > 5) {
            movie.element.classList.add("hide");
            movie.element.classList.remove("show");
        }
        document.addEventListener('click', function (event) {
            if (!movie.element.contains(event.target) && event.target !== searchInput) {
                movie.element.classList.add("hide");
                movie.element.classList.remove("show");
            }
        })
    });
});

fetch('http://localhost:8080/movie/allMovies')
    .then(res => {
        return res.json();
    })
    .then(data => {
        movies = data.map(movie => {
            const card = userCardTemplate.content.cloneNode(true).children[0];
            const cardImg = card.querySelector("[data-src]");
            const cardName = card.querySelector("[data-name]");
            const cardRank = card.querySelector("[data-rank]");
            cardImg.src = movie.imageLink;
            cardName.textContent = movie.movieTitle;
            cardRank.textContent = "#"+movie.rank;
            userCardContainer.append(card);
            card.onclick = function(){
                window.location.href = `../../../allMoviesById/allMoviesById.html?index=${movie.rank}`;
            };
            return {title:movie.movieTitle, element:card};
        })
    })
    .catch(error => console.log(error));

document.getElementById('RankButton').addEventListener("click", function(){
    window.location.href = '../allMoviesByRankAsc/allMoviesByRankAsc.html';
})

document.getElementById('ScoreButton').addEventListener("click", function(){
    window.location.href = '../../allMoviesByScore/allMoviesByScoreAsc/allMoviesByScoreAsc.html';
})

document.getElementById('YearButton').addEventListener("click", function(){
    window.location.href = '../../allMoviesByYear/allMoviesByYearAsc/allMoviesByYearAsc.html';
})

document.getElementById('Switch').addEventListener("click", function(){
    window.location.href = '../../../../tv/lists/allShowsByRank/allShowsByRankDesc/allShowsByRankDesc.html';
})
