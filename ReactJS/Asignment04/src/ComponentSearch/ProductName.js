import React from 'react'

class ProductName extends React.Component {
    render() {
        const product = this.props.product;
        const name = product.stocked ? product.stocked : <span style={{ color: 'red' }}>{product.name}</span>

        return (
            <tr>
                <td>{name}</td>
                <td>{product.price}</td>
            </tr>

        )
    }
}
export default ProductName;
