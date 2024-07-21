fetch('http://localhost:8080/tv/allShows/score/desc')
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(show=> {
            const rank = `<p>${show.rank}</p>`;
            const title = `<p><a href='../../../allShowsById/allShowsById.html?index=${show.rank}'">${show.showTitle}</a></p>`;
            let score;
            if ((show.score > 8 && show.score < 9) || (show.score > 9 && show.score < 10)) score = `<p>${show.score}</p>`;
            else score = `<p>${show.score}.0</p>`;
            const length = `<p>${show.episodes} eps</p>`;
            let year;
            if (show.endYear !== -1) year = `<p>${show.startYear}-${show.endYear}</p>`;
            else year = `<p>${show.startYear}-TBD</p>`;
            const rating = `<p>${show.rating}</p>`;
            document.querySelector('#showRank').insertAdjacentHTML('beforeend', rank);
            document.querySelector('#showTitle').insertAdjacentHTML('beforeend', title);
            document.querySelector('#showScore').insertAdjacentHTML('beforeend', score);
            document.querySelector('#showLength').insertAdjacentHTML('beforeend', length);
            document.querySelector('#showYear').insertAdjacentHTML('beforeend', year);
            document.querySelector('#showRating').insertAdjacentHTML('beforeend', rating);
        })
    })
    .catch(error => console.log(error));

const userCardTemplate = document.querySelector("[data-user-template]");
const userCardContainer = document.querySelector("[data-user-cards-container]");
const searchInput = document.querySelector("[data-search]");
let shows = [];
searchInput.addEventListener("input", (e) => {
    const value = e.target.value.trim().toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
    let count = 0;
    shows.forEach(show => {
        const title = show.title.toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
        let isVisible = title.includes(value);
        show.element.classList.toggle("hide", !isVisible);
        show.element.classList.toggle("show", isVisible);
        if (isVisible) {
            count++;
        }
        if (value === "") {
            isVisible = !isVisible;
            show.element.classList.toggle("hide", !isVisible);
            show.element.classList.toggle("show", isVisible);
        }
        if (count > 5) {
            show.element.classList.add("hide");
            show.element.classList.remove("show");
        }
        document.addEventListener('click', function (event) {
            if (!show.element.contains(event.target) && event.target !== searchInput) {
                show.element.classList.add("hide");
                show.element.classList.remove("show");
            }
        })
    });
});

searchInput.addEventListener('click', function () {
    const value = searchInput.value.trim().toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
    let count = 0;

    shows.forEach(show => {
        const title = show.title.toLowerCase().replaceAll(' ', '').replaceAll(':', '').replaceAll('-', '').replaceAll("'", "");
        const isVisible = title.includes(value);

        show.element.classList.toggle("hide", !isVisible);
        show.element.classList.toggle("show", isVisible);

        if (isVisible) {
            count++;
        }
        if (count > 5) {
            show.element.classList.add("hide");
            show.element.classList.remove("show");
        }
        document.addEventListener('click', function (event) {
            if (!show.element.contains(event.target) && event.target !== searchInput) {
                show.element.classList.add("hide");
                show.element.classList.remove("show");
            }
        })
    });
});

fetch('http://localhost:8080/tv/allShows')
    .then(res => {
        return res.json();
    })
    .then(data => {
        shows = data.map(show => {
            const card = userCardTemplate.content.cloneNode(true).children[0];
            const cardImg = card.querySelector("[data-src]");
            const cardName = card.querySelector("[data-name]");
            const cardRank = card.querySelector("[data-rank]");
            cardImg.src = show.imageLink;
            cardName.textContent = show.showTitle;
            cardRank.textContent = "#"+show.rank;
            userCardContainer.append(card);
            card.onclick = function(){
                window.location.href = `../../../allShowsById/allShowsById.html?index=${show.rank}`;
            };
            return {title:show.showTitle, element:card};
        })
    })
    .catch(error => console.log(error));

document.getElementById('RankButton').addEventListener("click", function(){
    window.location.href = '../../allShowsByRank/allShowsByRankAsc/allShowsByRankAsc.html';
})

document.getElementById('ScoreButton').addEventListener("click", function(){
    window.location.href = '../allShowsByScoreAsc/allShowsByScoreAsc.html';
})

document.getElementById('YearButton').addEventListener("click", function(){
    window.location.href = '../../allShowsByStartYear/allShowsByStartYearAsc/allShowsByStartYearAsc.html';
})

document.getElementById('Switch').addEventListener("click", function(){
    window.location.href = '../../../../movie/lists/allMoviesByScore/allMoviesByScoreDesc/allMoviesByScoreDesc.html';
})