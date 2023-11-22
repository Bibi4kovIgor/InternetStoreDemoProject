const React = require('react');
const ReactDOM = require('react-dom/client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {products: []};
	}

	componentDidMount() {
        fetch(
            "/api/v1/test/all", {
                method: 'GET'
        })
        .then((response) => response.json())
        .then((prod) => {
           console.log(prod)
           this.setState({products: prod});
        })
        .catch((error) => console.log(error));

    }
	render() {
        return (<ProductList products={this.state.products} />)
    }
}

class ProductList extends React.Component {
	render() {
		const products = this.props.products.map(prod =>
			<Product key={prod.id} data={prod} />
		);
        console.log(products)
		return (
			<table class="table">
				<tbody>
					<tr>
						<th scope="col">id</th>
						<th scope="col">Product Name</th>
						<th scope="col">Quantity</th>
						<th scope="col">Price</th>
						<th scope="col">Vendor Code</th>
						<th scope="col">Description</th>
					</tr>
					{products}
				</tbody>
			</table>
		)
	}
}

class Product extends React.Component{
	render() {

		return (
			<tr>
				<td>{this.props.data.id}</td>
				<td>{this.props.data.name}</td>
				<td>{this.props.data.quantity}</td>
				<td>{this.props.data.price}</td>
				<td>{this.props.data.vendorCode}</td>
				<td>{this.props.data.description}</td>
			</tr>
		)
	}
}

ReactDOM.createRoot(
  document.querySelector('#react')
).render(<App />)