
    function addToCart(button) {
        var formId = 'orderForm' + button.value;
        var form = document.getElementById(formId);

        var customerFormId = document.getElementById('customerFormId');
        form.appendChild(customerFormId);

        var productFormId = form.elements['productFormId'];
        form.appendChild(productFormId);

        var quantityInput = document.createElement('input');
//        quantityInput.type = 'hidden';
//        quantityInput.name = 'quantity';
//        quantityInput.value = quantity;
        quantityInput.type = 'hidden';
        quantityInput.name = 'quantity';
        quantityInput.value = 1;
        form.appendChild(quantityInput);

        form.submit();
    }
