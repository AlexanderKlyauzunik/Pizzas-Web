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

    let minus = element.querySelector(".order-item-sign-minus");
    minus.addEventListener("click", function() {
        let quantity_field = element.querySelector(".busket-button-quantity-text");
        let quantity = parseInt(quantity_field.textContent);
        if (quantity >  0) {
            let button_index = price_button.textContent.search(" ");
            let total_button_index = total_button.textContent.search(" ");
            total_button.textContent = (parseFloat(total_button.textContent.substring(0, total_button_index))
            - parseFloat(price_button.textContent.substring(0, button_index)) / quantity).toFixed(2) + " BYN";
            price_button.textContent = (parseFloat(price_button.textContent.substring(0, button_index))
            - parseFloat(price_button.textContent.substring(0, button_index)) / quantity).toFixed(2) + " BYN";
            quantity_field.textContent = quantity - 1;
            if (quantity == 1) {
                element.style.display = 'none';
            }
        }
    });
    let plus = element.querySelector(".order-item-sign-plus");
    plus.addEventListener("click", function() {
        let quantity_field = element.querySelector(".busket-button-quantity-text");
        let quantity = parseInt(quantity_field.textContent);
        let button_index = price_button.textContent.search(" ");
        let total_button_index = total_button.textContent.search(" ");
        total_button.textContent = (parseFloat(total_button.textContent.substring(0, total_button_index))
        + parseFloat(price_button.textContent.substring(0, button_index)) / quantity).toFixed(2) + " BYN";
        price_button.textContent = (parseFloat(price_button.textContent.substring(0, button_index)) 
        + parseFloat(price_button.textContent.substring(0, button_index)) / quantity).toFixed(2) + " BYN";
        quantity_field.textContent = quantity + 1;
    });
});

let total_button_index = total_button.textContent.search(" ");
total_button.textContent = (parseFloat(total_button.textContent.substring(0, total_button_index))
+ total_price).toFixed(2) + " BYN";
