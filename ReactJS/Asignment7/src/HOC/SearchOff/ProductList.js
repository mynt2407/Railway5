import React from 'react';
const products = [
    {
        "currencyFormat": "$",
        "description": "4 MSL",
        "id": 1,
        "isFreeShipping": true,
        "price": 10.9,
        "style": "Black with custom print",
        "title": "Cat Tee Black T-Shirt"
    },
    {
        "currencyFormat": "$",
        "description": "",
        "id": 2,
        "isFreeShipping": false,
        "price": 29.45,
        "style": "Front print and paisley print",
        "title": "Dark Thug Blue-Navy T-Shirt"
    },
    {

        "currencyFormat": "$",
        "description": "GPX Poly 1",
        "id": 3,
        "isFreeShipping": true,
        "price": 9,
        "style": "Front tie dye print",
        "title": "Sphynx Tie Dye Wine T-Shirt"
    },
    {

        "currencyFormat": "$",
        "description": "Treino 2014",
        "id": 4,
        "installments": 5,
        "isFreeShipping": false,
        "price": 14,
        "style": "Black T-Shirt with front print",
        "title": "Skuul"
    },
    {

        "currencyFormat": "$",
        "description": "",
        "id": 5,
        "isFreeShipping": true,
        "price": 13.25,
        "style": "Wine",
        "title": "Wine Skul T-Shirt"
    },
    {

        "currencyFormat": "$",
        "description": "14/15 s/nº",
        "id": 6,
        "isFreeShipping": false,
        "price": 10.9,
        "style": "Branco com listras pretas",
        "title": "Cat Tee Black T-Shirt"
    }
]
function ProductList(props) {
    return (
        <div>
            <p><b>Title: </b>{props.title}</p>
            <p><b>Style: </b>{props.style}</p>
            <p><b>Price: </b>{props.price}</p>
            <p><b>Description </b>{props.description}</p>
            <p><b>Free shipping </b>{props.isFreeShipping}</p>
        </div>
    )
}