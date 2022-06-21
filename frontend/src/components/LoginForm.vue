<template>
  <div class="container">
    <div class="text-center mt-5">
      <router-link to="/" class="text-dark text-decoration-none">
        <h1 class="display-3">Login</h1>
      </router-link>
    </div>
  </div>
  <div class="m-auto mt-5" style="max-width: 450px">
    <form role="form">
      <div>
        <div class="text-start">
          <label class="form-label" for="email">이메일</label>
        </div>
        <input type="text" class="form-control" id="email" name="email" autocomplete="off"/>
      </div>
      <div class="mt-3">
        <div class="text-start">
          <label class="form-label" for="password">비밀번호</label>
        </div>
        <input type="password" class="form-control" id="password" name="password" autocomplete="off"/>
      </div>
      <div class="d-grid gap-2 mt-3">
        <button type="button" class="btn btn-lg btn-danger">로그인</button>
      </div>
    </form>
    <hr/>
    <div class="d-grid gap-2 mt-3">
      <p>
        아직 회원이 아니신가요?
        <router-link to="/signup" class="text-decoration-none">회원가입</router-link>
      </p>
    </div>
    <div class="mt-4">
      <div class="d-grid gap-2">
        <button class="btn btn-lg btn-warning">카카오로 시작하기</button>
      </div>
      <div class="d-grid gap-2 mt-2">
        <button class="btn btn-lg btn-primary">구글로 시작하기</button>
      </div>
      <div class="d-grid gap-2 mt-2">
        <button class="btn btn-lg btn-success">네이버로 시작하기</button>
      </div>
    </div>
  </div>
</template>
