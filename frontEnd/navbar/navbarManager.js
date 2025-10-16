class NavbarManager extends HTMLElement {
  constructor() {
    super();
    this.attachShadow({ mode: 'open' }); // Enable Shadow DOM isolation
  }

  connectedCallback() {
    this.shadowRoot.innerHTML = `
      <link rel="stylesheet" href="navbar.css">
      <div class="nav">
        <img src="Logo.png" alt="Logo" class="logo">
        <input type="checkbox" id="nav-check">
        <div class="nav-header"></div>
        <div class="nav-btn">
          <label for="nav-check">
            <span></span>
            <span></span>
            <span></span>
          </label>
        </div>
        <div class="nav-links">
          <a href="dashboard.html">Inicio</a>
          <a href="profile.html">Perfil</a>
          <a href="settings.html">Configuración</a>
          <a href="landing.html">Cerrar Sesión</a>
        </div>
      </div>
    `;
  }
}

customElements.define('special-navbar', NavbarManager);