const form = document.getElementById("paamelding-skjema");
const submitButton = document.getElementById("button");
const globalError = document.getElementById("global-error");
const passord = document.getElementById("passord");
const bekreftPassord = document.getElementById("bekreftPassord");
const fornavn = document.getElementById("fornavn");
const etternavn = document.getElementById("etternavn");
const mobil = document.getElementById("mobil");

const textInputs = Array.from(form.querySelectorAll('input:not([type="radio"])'));
const namePattern = /^(?=.{2,20}$)[A-Za-zÆØÅæøå]+(?:-[A-Za-zÆØÅæøå]+)*$/;

const markTouched = input => {
    if (!input.dataset.touched) {
        input.dataset.touched = "true";
    }
};

const findInputContainer = input => input.closest(".inputfelt") ?? input.parentElement;

const setFieldMessage = (input, message, touched) => {
    const container = findInputContainer(input);
    if (!container) {
        return;
    }

    let messageNode = container.querySelector(".field-error");
    if (!touched || !message) {
        if (messageNode) {
            messageNode.remove();
        }
        return;
    }

    if (!messageNode) {
        messageNode = document.createElement("p");
        messageNode.className = "field-error";
        container.appendChild(messageNode);
    }
    messageNode.textContent = message;
};

const updateVisualState = (input, isValid) => {
    const touched = input.dataset.touched === "true";
    if (!touched) {
        input.classList.remove("is-invalid", "is-valid");
        setFieldMessage(input, "", touched);
        return;
    }

    input.classList.toggle("is-invalid", !isValid);
    input.classList.toggle("is-valid", isValid);
    const message = isValid ? "" : input.validationMessage;
    setFieldMessage(input, message, touched);
};

const validateField = input => {
    let message = "";
    const rawValue = input.value;
    const trimmedValue = rawValue.trim();

    if (input.required && trimmedValue === "") {
        message = "Påkrevd felt";
    } else if (input === passord && input.validity.patternMismatch) {
        message = "Minst 8 tegn, En stor bokstav og tall";
    } else if (input === bekreftPassord && rawValue !== passord.value) {
        message = "Passord må matche";
    } else if (input === fornavn || input === etternavn) {
        const validName = rawValue === trimmedValue && namePattern.test(trimmedValue);
        if (!validName) {
            message = "Kun bokstaver og -";
        }
    } else if (input === mobil && input.validity.patternMismatch) {
        message = "Skriv 8 siffer";
    }

    input.setCustomValidity(message);
    const isValid = input.checkValidity();
    updateVisualState(input, isValid);
    return isValid;
};

const updateSubmitState = () => {
    validateField(passord);
    validateField(bekreftPassord);
    submitButton.disabled = !form.checkValidity();
};

textInputs.forEach(input => {
    input.addEventListener("input", () => {
        markTouched(input);
        validateField(input);

        if (input === passord) {
            validateField(bekreftPassord);
        }

        globalError?.classList.add("hidden");
        submitButton.disabled = !form.checkValidity();
    });

    input.addEventListener("blur", () => {
        markTouched(input);
        validateField(input);
        if (input === passord) {
            validateField(bekreftPassord);
        }
        submitButton.disabled = !form.checkValidity();
    });
});

form.addEventListener("submit", event => {
    textInputs.forEach(input => {
        markTouched(input);
        validateField(input);
    });

    if (!form.reportValidity()) {
        event.preventDefault();
        submitButton.disabled = true;
        globalError?.classList.remove("hidden");
    } else {
        globalError?.classList.add("hidden");
    }


    
});

updateSubmitState();
