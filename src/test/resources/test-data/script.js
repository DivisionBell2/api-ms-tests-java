import { BasePage } from '../../shared/pages/BasePage'

const { I } = inject()

export class LoginPage extends BasePage {
  static BASE_URL = '/login'

  static selectors = {
    emailInput: { id: 'username-1' },
    passwordInput: { id: 'password-2' },
    loginLink: { css: '.styles_expand__1pbQ_' },
    loginButton: { css: '.form__container__btn--submit' },
  }

  static async login(userEmail: string, userPassword: string): Promise<void> {
    I.click(this.selectors.loginLink)
    I.fillField(this.selectors.emailInput, userEmail)
    I.fillField(this.selectors.passwordInput, userPassword)
    I.click(this.selectors.loginButton)
  }
}
