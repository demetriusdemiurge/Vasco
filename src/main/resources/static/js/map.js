let visitedCountries = [];
let wishlist = [];
var visitedCountriesButton = document.getElementById("visited_countries");
var wishlistButton = document.getElementById("wishlist");

document.addEventListener("DOMContentLoaded", () => {
    const paths = document.querySelectorAll("path[id]");
    const groups = document.querySelectorAll("g[id]");
    const countries = [...paths, ...groups];

    fetch('/api/marked-countries')
        .then(response => response.json())
        .then(data => {
            data.forEach(country => {
                const countryElement = document.getElementById(country.countryIsoCode);
                if (countryElement) {
                    if (country.marked) {
                        countryElement.style.fill = "#3F6C9AFF";
                        countryElement.dataset.clickCount = 2;
                        visitedCountries.push(countryElement);
                    } else {
                        countryElement.style.fill = "#3596FAFF";
                        countryElement.dataset.clickCount = 1;
                        wishlist.push(countryElement);
                    }
                }
            });
        })
        .catch(error => console.error('Error fetching marked countries:', error));

    countries.forEach(country => {

        country.dataset.clickCount = 0;

        country.addEventListener("click", () => {

            if (visitedCountriesButton.classList.contains("active")) {
                switchVisitedCountries();
            }
            if (wishlistButton.classList.contains("active")) {
                switchWishlist();
            }

            let count = parseInt(country.dataset.clickCount);
            count = (count + 1) % 3;
            country.dataset.clickCount = count;

            const color = count === 1 ? "#3596FAFF" :
                count === 2 ? "#3F6C9AFF" : "#ECECEC";

            paintCountry(country, color);

            switch (count) {
                case 1:
                    sendMark(country.id, false);
                    wishlist.push(country);
                    break;
                case 2:
                    sendMark(country.id, true);
                    wishlist.splice(wishlist.indexOf(country), 1);
                    visitedCountries.push(country);
                    break;
                default:
                    deleteMark(country.id);
                    visitedCountries.splice(visitedCountries.indexOf(country), 1);
                    break;
            }
        });

        country.addEventListener("hover", () => {

        });
    });
});

function sendMark(countryIsoCode, marked) {
    fetch("/api/mark-country", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            countryIsoCode: countryIsoCode,
            marked: marked
        })
    })
}

function deleteMark(countryIsoCode) {
    fetch(`/api/unmark-country/${countryIsoCode}`, {
        method: "DELETE"
    })
}

function paintCountry(country, color) {
    if (country.tagName.toLowerCase() === "g") {
        country.querySelectorAll("path").forEach(path => {
            path.style.fill = color;
        });
    } else {
        country.style.fill = color;
    }
}

function switchVisitedCountries() {
    if (wishlistButton.classList.contains("active")) {
        wishlistButton.classList.remove("active");
        visitedCountries.forEach(country => {
            paintCountry(country, "#3F6C9AFF");
        });
    }
    visitedCountriesButton.classList.toggle("active");
    if (visitedCountriesButton.classList.contains("active")) {
        wishlist.forEach(country => {
            paintCountry(country, "#ECECEC");
        });
    } else {
        wishlist.forEach(country => {
            paintCountry(country, "#3596FAFF");
        });
    }
}

function switchWishlist() {
    if (visitedCountriesButton.classList.contains("active")) {
        visitedCountriesButton.classList.remove("active");
        wishlist.forEach(country => {
            paintCountry(country, "#3596FAFF");
        });
    }
    wishlistButton.classList.toggle("active");
    if (wishlistButton.classList.contains("active")) {
        visitedCountries.forEach(country => {
            paintCountry(country, "#ECECEC");
        });
    } else {
        visitedCountries.forEach(country => {
            paintCountry(country, "#3F6C9AFF");
        });
    }
}