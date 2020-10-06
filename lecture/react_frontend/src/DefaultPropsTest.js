import React, {Component} from "react";

class DefaultPropsTest extends Component {
    static defaultProps = {
        name: 'Default Name'
    }
    render() {
        return(
            <div>
                DefaultPropsTest Awesome Golang Based { this.props.name }
            </div>
        )
    }
}

export default DefaultPropsTest