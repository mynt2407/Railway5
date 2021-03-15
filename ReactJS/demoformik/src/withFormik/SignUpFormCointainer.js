import { withFormik } from "formik"
import SignUpFormUI from "./SignUpFormUI";

const container = withFormik({
    mapPropsToValues: () => ({
        firstName: '',
        lastName: '',
        email: ''
    }),
    validate: values => {
        const errors = {};
        // firstname
        if (!values.firstName) {
            errors.firstName = 'Required';
        } else if (values.firstName.length < 5) {
            errors.firstName = 'Must be 5 characters or greater';
        }
        // lastname
        if (!values.lastName) {
            errors.lastName = 'Required';
        } else if (values.lastName.length < 5) {
            errors.lastName = 'Must be 5 characters or greater';
        }
        // email
        if (!values.email) {
            errors.email = 'Required';
        } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
            errors.email = 'Invalid email address';
        }
        return errors;
    },
    handleSubmit: values => {
        alert(JSON.stringify(values, null, 2));
    },
    displayName: 'SignupFormUI'
})(SignUpFormUI);

export default container;