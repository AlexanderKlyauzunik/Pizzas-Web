
const all_prices = [14.99, 20.99, 16.99, 22.99]

//pizza price according to size

var size_select_elements = document.querySelectorAll(".size-select");
size_select_elements.forEach(element => {
    const element_id = element.id.charAt(5);
    const price_name = "price-" + element_id;
    element.addEventListener("change", function() {
        var text = document.getElementById(price_name).textContent;
        var index = text.search(" ");
        if (element.options[0].value == "Big") {
            document.getElementById(price_name).textContent
            = (parseFloat(document.getElementById(price_name).textContent.substring(0, index)) + 5).toFixed(2) + " BYN";
        }
        else {
            document.getElementById(price_name).textContent
            = (parseFloat(document.getElementById(price_name).textContent.substring(0, index)) - 5).toFixed(2) + " BYN";
        }
    });
});

//pizza price according to dough type

var dough_select_elements = document.querySelectorAll(".dough-select");
dough_select_elements.forEach(element => {
    const element_id = element.id.charAt(6);
    const price_name = "price-" + element_id;
    element.addEventListener("change", function() {
        var text = document.getElementById(price_name).textContent;
        var index = text.search(" ");
        if (element.options[0].value == "Thick") {
            document.getElementById(price_name).textContent
            = (parseFloat(document.getElementById(price_name).textContent.substring(0, index)) + 2).toFixed(2) + " BYN";
        }
        else {
            document.getElementById(price_name).textContent
            = (parseFloat(document.getElementById(price_name).textContent.substring(0, index)) - 2).toFixed(2) + " BYN";
        }
    });
});

//

var busket = document.querySelector(".busket-button-text-orig");
var busket_quantity = document.querySelector(".busket-button-quantity-text");

var pizza_buskets = document.querySelectorAll(".profile-button");
pizza_buskets.forEach(element => {
    const element_id = element.id.charAt(7);
    const price_name = "price-" + element_id;
    element.addEventListener("click", function() {
        var text = document.getElementById(price_name).textContent;
        var index = text.search(" ");
        var busket_index = busket.textContent.search(" ");
        const prev_price = parseFloat(busket.textContent.substring(0, busket_index));
        var new_price = prev_price + parseFloat(document.getElementById(price_name).textContent.substring(0, index));
        busket.textContent = new_price.toFixed(2) + " BYN";
        const new_quantity = parseInt(busket_quantity.textContent) + 1;
        busket_quantity.textContent = new_quantity;
    });
});

var drink_buskets = document.querySelectorAll(".drink-button");
drink_buskets.forEach(element => {
    var button_index = element.id.search("-");
    const element_id = element.id.substring(button_index + 1);
    const price_name = "dprice-" + element_id;
    console.log(price_name);
    element.addEventListener("click", function() {
        var text = document.getElementById(price_name).textContent;
        var index = text.search(" ");
        var busket_index = busket.textContent.search(" ");
        const prev_price = parseFloat(busket.textContent.substring(0, busket_index));
        var new_price = prev_price + parseFloat(document.getElementById(price_name).textContent.substring(0, index));
        busket.textContent = new_price.toFixed(2) + " BYN";
        const new_quantity = parseInt(busket_quantity.textContent) + 1;
        busket_quantity.textContent = new_quantity;
    });
});

//

const element1 = document.querySelectorAll(".menu-choices");

element1.forEach(element => {
    new Choices(element, {
        searchEnabled: false,
        itemSelectText: ""
    })
});

// (function() {
//     const loginButton = document.querySelector('.profile-button-orig');
//     const loginForm = document.querySelector('.login-box');
//     const toggleForm = function () {
//         loginForm.classList.toggle("open");
//     }
    
//     loginButton.addEventListener("click", function (e) {
//         e.stopPropagation();
//         toggleForm();
//     });

//     document.addEventListener("click", function (e) {
//         const target = e.target;
//         const its_form = target == loginForm || loginForm.contains(target);
//         const its_button = target == loginButton;
//         const form_is_active = loginForm.classList.contains("open");
    
//         if (!its_form && !its_button && form_is_active) {
//             toggleForm();
//         }
//     });
// }());

let loginButton = document.querySelector(".profile-button-orig");
let loginText = document.querySelector(".profile-button-text-orig");

loginButton.addEventListener("click", function() {
    window.open("./frontend/html/profile.html");
});

let loginFlag = 0;

function registerRefClicked() {
    if (!loginFlag) {
        document.querySelector('.login-title').textContent = 'Создать аккаунт';
        document.querySelectorAll('.login-element').forEach(button => {
            button.style.display = 'none';
        });
        document.querySelector('.login-sign-in-button').textContent = 'Зарегистрироваться';
        document.querySelector('.login-form-ref').style.display = 'none';
        document.querySelector('.login-form-register-text').textContent = 'Уже есть аккаунт?';
        document.querySelector('.login-form-register-ref').textContent = 'Войти';
        document.querySelector('.login-box').style.marginTop = '-210px';
        loginFlag = 1;
    }
    else if (loginFlag) {
        document.querySelector('.login-title').textContent = 'Войти в аккаунт';
        document.querySelectorAll('.login-element').forEach(button => {
            button.style.display = 'block';
        });
        document.querySelector('.login-sign-in-button').textContent = 'Войти';
        document.querySelector('.login-form-ref').style.display = 'block';
        document.querySelector('.login-form-register-text').textContent = "Еще нет аккаунта?";
        document.querySelector('.login-form-register-ref').textContent = 'Зарегистрироваться';
        document.querySelector('.login-box').style.marginTop = '-210px';
        loginFlag = 0;
    }
}

// Scroll to anchors
(function () {

    const smoothScroll = function (targetEl, duration) {
        let target = document.querySelector(targetEl);
        let targetPosition = target.getBoundingClientRect().top;
        let startPosition = window.pageYOffset;
        let startTime = null;
    
        const ease = function(t,b,c,d) {
            t /= d / 2;
            if (t < 1) return c / 2 * t * t + b;
            t--;
            return -c / 2 * (t * (t - 2) - 1) + b;
        };
    
        const animation = function(currentTime){
            if (startTime === null) startTime = currentTime;
            const timeElapsed = currentTime - startTime;
            const run = ease(timeElapsed, startPosition, targetPosition, duration);
            window.scrollTo(0,run);
            if (timeElapsed < duration) requestAnimationFrame(animation);
        };
        requestAnimationFrame(animation);

    };

    const scrollTo = function () {
        const links = document.querySelectorAll('.js-scroll');
        links.forEach(each => {
            each.addEventListener('click', function () {
                const currentTarget = this.getAttribute('href');
                smoothScroll(currentTarget, 800);
            });
        });
    };
    scrollTo();
}());