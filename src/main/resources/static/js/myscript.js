
const form = document.getElementById("paamelding-skjema");
const submitButton = document.getElementById("button");
const globalError = document.getElementById("global-error");
const passord = document.getElementById("passord");
const bekreftPassord = document.getElementById("bekreftPassord");
const fornavn = document.getElementById("fornavn");
const etternavn = document.getElementById("etternavn");
const mobil = document.getElementById("mobil");
const inputs = Array.from(form.querySelectorAll('input:not([type="radio"])'));
const namePattern = /^(?=.{2,20}$)[A-Za-zÆØÅæøå]+(?:-[A-Za-zÆØÅæøå]+)*$/;

const markTouched = input => {
    input.dataset.touched = "true";
};
const findContainer = input => input.closest(".inputfelt") ?? input.parentElement;

const showMessage = (input, message) => {
    const container = findContainer(input);
    if (!container) {
        return;
    }

    let node = container.querySelector(".field-error");
    const shouldShow = input.dataset.touched === "true" && message;

    if (!shouldShow) {
        node?.remove();
        return;
    }

    if (!node) {
        node = document.createElement("p");
        node.className = "field-error";
        container.appendChild(node);
    }
    node.textContent = message;
};

const getMessage = input => {
    const value = input.value;
    const trimmed = value.trim();

    if (input.required && !trimmed) {
        return "Påkrevd felt";
    }
    if ((input === fornavn || input === etternavn) && (value !== trimmed || !namePattern.test(trimmed))) {
        return "Kun bokstaver og -";
    }
    if (input === passord && input.validity.patternMismatch) {
        return "Minst 8 tegn, En stor bokstav og tall";
    }
    if (input === bekreftPassord && value !== passord.value) {
        return "Passord må matche";
    }
    if (input === mobil && input.validity.patternMismatch) {
        return "Skriv 8 siffer";
    }
    return "";
};

const validate = input => {
    const message = getMessage(input);
    input.setCustomValidity(message);
    const isValid = input.checkValidity();
    const touched = input.dataset.touched === "true";

    input.classList.toggle("is-valid", touched && isValid);
    input.classList.toggle("is-invalid", touched && !isValid);
    showMessage(input, touched ? message : "");
    return isValid;
};

const syncSubmitState = () => {
    if (passord && bekreftPassord) {
        [passord, bekreftPassord].forEach(validate);
    }
    submitButton.disabled = !form.checkValidity();
};

const handleFieldEvent = input => {
    markTouched(input);
    if (passord && bekreftPassord && (input === passord || input === bekreftPassord)) {
        [passord, bekreftPassord].forEach(validate);
    } else {
        validate(input);
    }
    globalError?.classList.add("hidden");
    syncSubmitState();
};

inputs.forEach(input => {
    ["input", "blur"].forEach(evt => input.addEventListener(evt, () => handleFieldEvent(input)));
});

form.addEventListener("change", event => {
    if (event.target.matches('input[type="radio"], input[type="checkbox"], select')) {
        globalError?.classList.add("hidden");
        syncSubmitState();
    }
});

form.addEventListener("submit", event => {
    inputs.forEach(input => {
        markTouched(input);
        validate(input);
    });

    if (!form.reportValidity()) {
        event.preventDefault();
        submitButton.disabled = true;
        globalError?.classList.remove("hidden");
    } else {
        globalError?.classList.add("hidden");
    }
});

syncSubmitState();
