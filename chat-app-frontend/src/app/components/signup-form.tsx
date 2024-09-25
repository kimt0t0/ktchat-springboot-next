import { FC, FormEvent } from "react";

interface ISignupFormProps {
    onSubmit: (e: FormEvent<HTMLFormElement>) => void;
}

const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    alert('Form submitted !');
};

const SignupForm: FC<ISignupFormProps> = () => {
    return (
    <form onSubmit={handleSubmit}>
        <div className="input-group">
            <label htmlFor="username">Pseudo:</label>
            <input type="username" id="username" name="username" required />
        </div>
        <div className="input-group">
            <label htmlFor="email">Email:</label>
            <input type="email" id="email" name="email" required />
        </div>
        <div className="input-group">
            <label htmlFor="password">Mot-de-passe:</label>
            <input type="password" id="password" name="password" required />
        </div>
        <button type="submit">Sign Up</button>
    </form>
    );
};

export default SignupForm;