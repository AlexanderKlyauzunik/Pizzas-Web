function loadData() {
    let busket = document.querySelector(".busket-button-text");
    if (typeof localStorage["busket-price"] === 'undefined') {
        localStorage["busket-price"] = '0.00';
    }
    busket.textContent = localStorage["busket-price"] + " BYN";

    let next_elem = document.querySelector(".order-refs");
    for (let i = 1; i <= 6; i++) {
        if (localStorage["quantity-pizza-Mid-Thin-" + i] > 0) {
            next_elem.insertAdjacentHTML("beforebegin", `<div id="` + "pizza-Mid-Thin-" + i + `" class="order-item">
        <img src="` + localStorage["pizza-image-" + i] + `" alt="Order item" class="order-item-pic">
        <div class="description-box">
        <p class="order-item-title">` + localStorage["pizza-name-" + i] + `</p>
        <p class="order-item-size">Средняя</p>
        <p class="order-item-dough">Тонкое</p>
        </div>
        <div class="order-item-quantity">
            <input type="image" src="../img/minus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-minus">
            <button class="busket-button-quantity">
                <p class="busket-button-quantity-text">` + localStorage["quantity-pizza-Mid-Thin-" + i] + `</p>
            </button>
            <input type="image" src="../img/plus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-plus">
        </div>
        <button class="busket-button-orig">
            <p class="busket-button-text-orig">` + localStorage["price-pizza-Mid-Thin-" + i] + ` BYN</p>
        </button>
        </div>`);
        }
    }

    for (let i = 1; i <= 6; i++) {
        if (localStorage["quantity-pizza-Mid-Thick-" + i] > 0) {
            next_elem.insertAdjacentHTML("beforebegin", `<div id="` + "pizza-Mid-Thick-" + i + `" class="order-item">
        <img src="` + localStorage["pizza-image-" + i] + `" alt="Order item" class="order-item-pic">
        <div class="description-box">
        <p class="order-item-title">` + localStorage["pizza-name-" + i] + `</p>
        <p class="order-item-size">Средняя</p>
        <p class="order-item-dough">Толстое</p>
        </div>
        <div class="order-item-quantity">
            <input type="image" src="../img/minus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-minus">
            <button class="busket-button-quantity">
                <p class="busket-button-quantity-text">` + localStorage["quantity-pizza-Mid-Thick-" + i] + `</p>
            </button>
            <input type="image" src="../img/plus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-plus">
        </div>
        <button class="busket-button-orig">
            <p class="busket-button-text-orig">` + localStorage["price-pizza-Mid-Thick-" + i] + ` BYN</p>
        </button>
        </div>`);
        }
    }

    for (let i = 1; i <= 6; i++) {
        if (localStorage["quantity-pizza-Big-Thin-" + i] > 0) {
            next_elem.insertAdjacentHTML("beforebegin", `<div id="` + "pizza-Big-Thin-" + i + `" class="order-item">
        <img src="` + localStorage["pizza-image-" + i] + `" alt="Order item" class="order-item-pic">
        <div class="description-box">
        <p class="order-item-title">` + localStorage["pizza-name-" + i] + `</p>
        <p class="order-item-size">Большая</p>
        <p class="order-item-dough">Тонкое</p>
        </div>
        <div class="order-item-quantity">
            <input type="image" src="../img/minus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-minus">
            <button class="busket-button-quantity">
                <p class="busket-button-quantity-text">` + localStorage["quantity-pizza-Big-Thin-" + i] + `</p>
            </button>
            <input type="image" src="../img/plus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-plus">
        </div>
        <button class="busket-button-orig">
            <p class="busket-button-text-orig">` + localStorage["price-pizza-Big-Thin-" + i] + ` BYN</p>
        </button>
        </div>`);
        }
    }

    for (let i = 1; i <= 6; i++) {
        if (localStorage["quantity-pizza-Big-Thick-" + i] > 0) {
            next_elem.insertAdjacentHTML("beforebegin", `<div id="` + "pizza-Big-Thick-" + i + `" class="order-item">
        <img src="` + localStorage["pizza-image-" + i] + `" alt="Order item" class="order-item-pic">
        <div class="description-box">
        <p class="order-item-title">` + localStorage["pizza-name-" + i] + `</p>
        <p class="order-item-size">Большая</p>
        <p class="order-item-dough">Толстое</p>
        </div>
        <div class="order-item-quantity">
            <input type="image" src="../img/minus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-minus">
            <button class="busket-button-quantity">
                <p class="busket-button-quantity-text">` + localStorage["quantity-pizza-Big-Thick-" + i] + `</p>
            </button>
            <input type="image" src="../img/plus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-plus">
        </div>
        <button class="busket-button-orig">
            <p class="busket-button-text-orig">` + localStorage["price-pizza-Big-Thick-" + i] + ` BYN</p>
        </button>
        </div>`);
        }
    }

    for (let i = 1; i <= 10; i++) {
        if (localStorage["quantity-drink-" + i] > 0) {
            next_elem.insertAdjacentHTML("beforebegin", `<div id="` + "drink-" + i + `" class="order-item">
        <img src="` + localStorage["drink-image-" + i] + `" alt="Order item" class="order-item-pic">
        <p class="order-item-title">` + localStorage["drink-name-" + i] + `</p>
        <div class="order-item-quantity">
            <input type="image" src="../img/minus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-minus">
            <button class="busket-button-quantity">
                <p class="busket-button-quantity-text">` + localStorage["quantity-drink-" + i] + `</p>
            </button>
            <input type="image" src="../img/plus-svgrepo-com.svg" alt="Order item sign" class="order-item-sign-plus">
        </div>
        <button class="busket-button-orig">
            <p class="busket-button-text-orig">` + localStorage["price-drink-" + i] + ` BYN</p>
        </button>
        </div>`);
        }
    }
}

loadData();

//localStorage.clear();


const element1 = document.querySelectorAll(".payment-form-select");

element1.forEach(element => {
    new Choices(element, {
        searchEnabled: false,
        itemSelectText: ""
    })
});



let loginButton = document.querySelector(".profile-button-orig");
let loginText = document.querySelector(".profile-button-text-orig");

loginButton.addEventListener("click", function() {
    window.open("../html/profile.html");
});

//

let total_price = 0;
let total_button = document.querySelector(".busket-button-text");

let order_item = document.querySelectorAll(".order-item");

order_item.forEach(element => {
    let price_button = element.querySelector(".busket-button-text-orig");

    let button_index = price_button.textContent.search(" ");
    total_price += parseFloat(price_button.textContent.substring(0, button_index));

    let localprice = "price-" + element.id;
    let localquantity = "quantity-" + element.id;
    console.log(localquantity);

    let minus = element.querySelector(".order-item-sign-minus");
    minus.addEventListener("click", function() {
        let quantity_field = element.querySelector(".busket-button-quantity-text");
        let quantity = parseInt(quantity_field.textContent);
        if (quantity > 0) {

            localStorage["busket-price"] = (parseFloat(localStorage["busket-price"]) - parseFloat(localStorage[localprice]) / parseInt(localStorage[localquantity])).toFixed(2);
            localStorage["busket-quantity"] = parseInt(localStorage["busket-quantity"]) - 1;
            localStorage[localprice] = (parseFloat(localStorage[localprice]) - parseFloat(localStorage[localprice]) / parseInt(localStorage[localquantity])).toFixed(2);
            localStorage[localquantity] = quantity - 1;

            
            price_button.textContent = localStorage[localprice] + " BYN";
            quantity_field.textContent = quantity - 1;
            total_button.textContent = localStorage["busket-price"] + " BYN";
            if (quantity == 1) {
                element.style.display = 'none';
            }
        }
    });
    let plus = element.querySelector(".order-item-sign-plus");
    plus.addEventListener("click", function() {
        let quantity_field = element.querySelector(".busket-button-quantity-text");
        let quantity = parseInt(quantity_field.textContent);

        console.log(parseFloat(localStorage[localprice]));
        localStorage["busket-price"] = (parseFloat(localStorage["busket-price"]) + parseFloat(localStorage[localprice]) / parseInt(localStorage[localquantity])).toFixed(2);
        localStorage["busket-quantity"] = parseInt(localStorage["busket-quantity"]) + 1;
        localStorage[localprice] = (parseFloat(localStorage[localprice]) + parseFloat(localStorage[localprice]) / parseInt(localStorage[localquantity])).toFixed(2);
        localStorage[localquantity] = quantity + 1;
            
        price_button.textContent = localStorage[localprice] + " BYN";
        quantity_field.textContent = quantity + 1;
        total_button.textContent = localStorage["busket-price"] + " BYN";
    });
});