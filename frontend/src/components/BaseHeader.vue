<template>
  <div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 border-bottom">
      <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
        <h1 class="m-auto">Home</h1>
      </a>
      <ul class="nav d-flex align-items-center">
        <li class="nav-item">
          <router-link to="/login" class="text-decoration-none me-3">Login</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/signup" class="text-decoration-none text-secondary">Signup</router-link>
        </li>
      </ul>
    </header>
  </div>
</template>
