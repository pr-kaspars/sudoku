import React from 'react'
import { addToCart } from '../actions'

class Cell extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            value: props.value
        };
    }

    getClassNames() {
        let cn = ["item"];
        if (this.props.index % 3 == 0) {
            cn.push("border-left")
        }
        if ((this.props.index + 1) % 3 == 0) {
            cn.push("border-right")
        }
        if (Math.floor(this.props.index / 9) % 3 == 0) {
            cn.push("border-top")
        }
        if ((Math.floor(this.props.index / 9) + 1) % 3 == 0) {
            cn.push("border-bottom")
        }
        if (this.state.active) {
            cn.push("selected")
        }
        return cn;
    }

    render() {
        return (
        <div className={this.getClassNames().join(" ")}>
            <input
                className={this.props.error ? "error" : ""}
                value={this.state.value}
                onChange={this.handleOnChange.bind(this)}
                onKeyPress={this.handleOnKeyPress.bind(this)}
                size="1"
                maxLength="1"
            />
        </div>);
    }

    handleOnChange(e) {
        var v = parseInt(e.target.value);
        if (!isNaN(v) && v >= 1 && v <= 9) {
            this.setState({ value: v });
            this.props.onChange(v);
        }
    }

    handleOnKeyPress(e) {
        var c = e.charCode;
        if (c >= 49 && c <= 57) {
            this.setState({ value: e.key });
            this.props.onChange(parseInt(e.key));
        }
    }
}
 
export default Cell
