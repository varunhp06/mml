fetch(`http://localhost:8080/tv/allShows/desc`)
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(show => {
            const markup = `<li>
                                    <ul>${show.rank}</ul>
                                    <ul>${show.showTitle}</ul>
                                    <ul>${show.score}</ul>
                                    <ul>${show.startYear}</ul>
                                    <ul>${show.endYear}</ul>
                                    <ul>${show.rating}</ul>
                                    <ul>${show.episodes} eps</ul> 
                                </li>`;
            document.querySelector('#allShowsByRankDesc').insertAdjacentHTML('beforeend', markup);
        })
    })
    .catch(error => console.log(error));