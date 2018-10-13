(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./project/project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
/* harmony import */ var _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./project/project-post/project-post.component */ "./src/app/project/project-post/project-post.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




var routes = [
    {
        path: '',
        redirectTo: 'projects',
        pathMatch: 'full'
    },
    {
        path: 'projects',
        component: _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__["ProjectListComponent"],
        data: { title: 'Projects' }
    },
    {
        path: 'projects/post',
        component: _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_3__["ProjectPostComponent"],
        data: { title: 'New Project' }
    },
    {
        path: '**',
        redirectTo: ''
    }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navbar></app-navbar>\n<main role=\"main\">\n  <div id=\"content\" class=\"max-width-wrapper container align-self-auto\">\n    <router-outlet></router-outlet>\n  </div>\n</main>\n"

/***/ }),

/***/ "./src/app/app.component.scss":
/*!************************************!*\
  !*** ./src/app/app.component.scss ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var AppComponent = /** @class */ (function () {
    function AppComponent(route, titleService, activatedRoute) {
        this.route = route;
        this.titleService = titleService;
        this.activatedRoute = activatedRoute;
        this.title = 'frontend';
    }
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.events.pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["filter"])(function (event) { return event instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function () { return _this.activatedRoute; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["map"])(function (route) {
            while (route.firstChild) {
                route = route.firstChild;
            }
            return route;
        }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["filter"])(function (route) { return route.outlet === 'primary'; }), Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_1__["mergeMap"])(function (route) { return route.data; })).subscribe(function (event) { return _this.titleService.setTitle(event['title'] + ' - sudoCode'); });
    };
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.scss */ "./src/app/app.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["Title"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"]])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: XhrInterceptor, AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "XhrInterceptor", function() { return XhrInterceptor; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./navbar/navbar.component */ "./src/app/navbar/navbar.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./project/project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
/* harmony import */ var _project_project_card_project_card_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./project/project-card/project-card.component */ "./src/app/project/project-card/project-card.component.ts");
/* harmony import */ var _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./project/project-post/project-post.component */ "./src/app/project/project-post/project-post.component.ts");
/* harmony import */ var _project_project_search_project_search_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./project/project-search/project-search.component */ "./src/app/project/project-search/project-search.component.ts");
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./header/header.component */ "./src/app/header/header.component.ts");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./shared/project.service */ "./src/app/shared/project.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};














var XhrInterceptor = /** @class */ (function () {
    function XhrInterceptor() {
    }
    XhrInterceptor.prototype.intercept = function (req, next) {
        var xhr = req.clone({
            headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
        });
        return next.handle(xhr);
    };
    XhrInterceptor = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
    ], XhrInterceptor);
    return XhrInterceptor;
}());

var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_4__["NavbarComponent"],
                _project_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_6__["ProjectListComponent"],
                _project_project_card_project_card_component__WEBPACK_IMPORTED_MODULE_7__["ProjectCardComponent"],
                _project_project_post_project_post_component__WEBPACK_IMPORTED_MODULE_8__["ProjectPostComponent"],
                _project_project_search_project_search_component__WEBPACK_IMPORTED_MODULE_9__["ProjectSearchComponent"],
                _header_header_component__WEBPACK_IMPORTED_MODULE_10__["HeaderComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__["BrowserAnimationsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormsModule"]
            ],
            providers: [
                _shared_project_service__WEBPACK_IMPORTED_MODULE_13__["ProjectService"], { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HTTP_INTERCEPTORS"], useClass: XhrInterceptor, multi: true }
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/header/header.component.html":
/*!**********************************************!*\
  !*** ./src/app/header/header.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"header\">\n  <h2>{{headerText}}</h2>\n  <hr>\n</div>\n"

/***/ }),

/***/ "./src/app/header/header.component.scss":
/*!**********************************************!*\
  !*** ./src/app/header/header.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#header {\n  margin-top: 3rem;\n  margin-bottom: 3rem;\n  font-family: Montserrat, sans-serif; }\n"

/***/ }),

/***/ "./src/app/header/header.component.ts":
/*!********************************************!*\
  !*** ./src/app/header/header.component.ts ***!
  \********************************************/
/*! exports provided: HeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HeaderComponent", function() { return HeaderComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HeaderComponent = /** @class */ (function () {
    function HeaderComponent() {
    }
    HeaderComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", String)
    ], HeaderComponent.prototype, "headerText", void 0);
    HeaderComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-header',
            template: __webpack_require__(/*! ./header.component.html */ "./src/app/header/header.component.html"),
            styles: [__webpack_require__(/*! ./header.component.scss */ "./src/app/header/header.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], HeaderComponent);
    return HeaderComponent;
}());



/***/ }),

/***/ "./src/app/navbar/navbar.component.html":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-expand-sm navbar-dark\">\n  <div id=\"inner-nav\" class=\"container max-width-wrapper\">\n    <a class=\"navbar-brand\" routerLink=\"/\">(sudoCode);</a>\n    <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#mainNav\">\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <div class=\"collapse navbar-collapse\" id=\"mainNav\">\n      <div class=\"navbar-expand\">\n        <div class=\"navbar-nav\">\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             [routerLinkActiveOptions]=\"{exact: true}\" routerLink=\"/\">Home</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             routerLink=\"projects\">Projects</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             routerLink=\"#\">Contact</a>\n        </div>\n      </div>\n    </div>\n    <div class=\"mavbar=expand ml-auto\">\n\n      <div class=\"navbar-nav\" *ngIf=\"!auth.authenticated\">\n        <a class=\"nav-item nav-link\" href=\"http://localhost:8080/oauth2/authorization/github\">\n          <i class=\"fa fa-github fa-lg\"></i> <span> Login</span>\n        </a>\n      </div>\n\n      <li class=\"nav-item dropdown\" *ngIf=\"auth.authenticated\">\n        <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n          <span class=\"login\">{{auth.currentUser?.login}} </span>\n          <img src=\"{{auth.currentUser?.avatarUrl}}\" style=\"max-width: 40px; border-radius: 50px; padding: 0; margin: 0\">\n        </a>\n        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n          <a class=\"dropdown-item\" (click)=\"auth.logout()\" style=\"cursor: pointer\">Logout</a>\n        </div>\n      </li>\n\n    </div>\n  </div>\n</nav>\n"

/***/ }),

/***/ "./src/app/navbar/navbar.component.scss":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".navbar {\n  background-color: #1c2331 !important;\n  font-size: .9rem;\n  font-family: Montserrat, sans-serif;\n  min-height: 56px;\n  padding-bottom: 0;\n  padding-top: 0;\n  box-sizing: border-box;\n  box-shadow: 0 5px 21px -11px rgba(31, 31, 33, 0.62);\n  border-top: 4px solid #639fab; }\n  .navbar .navbar-brand {\n    font-size: 1.5rem;\n    font-weight: 700; }\n  .navbar .container {\n    width: 88vw;\n    min-height: 80px; }\n  .navbar .container .nav-link {\n      text-transform: uppercase;\n      font-size: .9rem;\n      font-weight: 700;\n      letter-spacing: 0;\n      cursor: pointer;\n      color: rgba(255, 251, 254, 0.7); }\n  .navbar .container .nav-link:hover {\n        color: white; }\n  .navbar .container .active {\n      border-bottom: 2px solid #639fab;\n      color: white; }\n  .dropdown-toggle::after {\n  display: none; }\n  .login {\n  padding-right: 1rem;\n  color: #f1f1f1; }\n"

/***/ }),

/***/ "./src/app/navbar/navbar.component.ts":
/*!********************************************!*\
  !*** ./src/app/navbar/navbar.component.ts ***!
  \********************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var NavbarComponent = /** @class */ (function () {
    function NavbarComponent(activatedRoute, auth) {
        this.activatedRoute = activatedRoute;
        this.auth = auth;
    }
    NavbarComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.activatedRoute.params.subscribe(function (params) {
            console.log(params);
            _this.auth.authenticate(undefined);
        });
    };
    NavbarComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! ./navbar.component.html */ "./src/app/navbar/navbar.component.html"),
            styles: [__webpack_require__(/*! ./navbar.component.scss */ "./src/app/navbar/navbar.component.scss")]
        }),
        __metadata("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"], _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"]])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/project/project-card/project-card.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-card/project-card.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"project-card\" class=\"container\">\n  <h4><span class=\"title\">{{project?.title}}</span>\n    <span id=\"difficulty\" class=\"badge font-weight-normal\">\n      ({{project?.difficulty}})\n    </span>\n  </h4>\n  <!--<h6 id=\"difficulty\">{{project.difficulty}}</h6>-->\n  <p class=\"text-body\" id=\"description\">{{project?.description}}</p>\n  <hr class=\"my-2\">\n  <h6 id=\"metadata\">\n      <span class=\"user-details\">\n        <img src=\"{{project?.author.avatarUrl}}\" class=\"avatar\">\n        {{project?.author.login}}</span>\n      <span class=\"date\">{{project?.date_posted | date: 'MMM. d, y'}}</span>\n  </h6>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-card/project-card.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-card/project-card.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#project-card {\n  border-radius: 5px;\n  margin-bottom: 4rem; }\n  #project-card .title {\n    color: #1c2331;\n    font-family: \"Montserrat\", sans-serif;\n    font-weight: 500; }\n  #project-card .title:hover {\n      color: #639fab;\n      cursor: pointer; }\n  #project-card #description {\n    font-size: 1rem;\n    margin-left: .5rem;\n    word-wrap: break-spaces; }\n  #project-card #metadata {\n    font-size: .9rem;\n    padding-top: .5rem;\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: (auto)[2];\n        grid-template-columns: repeat(2, auto); }\n  #project-card #metadata .user-details {\n      -ms-grid-column-align: left;\n          justify-self: left; }\n  #project-card #metadata .user-details .avatar {\n        max-height: 20px;\n        border-radius: 50px; }\n  #project-card #metadata .date {\n      -ms-grid-column-align: right;\n          justify-self: right; }\n  #project-card #difficulty {\n    color: gray;\n    padding-bottom: 1rem; }\n"

/***/ }),

/***/ "./src/app/project/project-card/project-card.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/project/project-card/project-card.component.ts ***!
  \****************************************************************/
/*! exports provided: ProjectCardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectCardComponent", function() { return ProjectCardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ProjectCardComponent = /** @class */ (function () {
    function ProjectCardComponent() {
    }
    ProjectCardComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], ProjectCardComponent.prototype, "project", void 0);
    ProjectCardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-card',
            template: __webpack_require__(/*! ./project-card.component.html */ "./src/app/project/project-card/project-card.component.html"),
            styles: [__webpack_require__(/*! ./project-card.component.scss */ "./src/app/project/project-card/project-card.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], ProjectCardComponent);
    return ProjectCardComponent;
}());



/***/ }),

/***/ "./src/app/project/project-list/mock-projects.ts":
/*!*******************************************************!*\
  !*** ./src/app/project/project-list/mock-projects.ts ***!
  \*******************************************************/
/*! exports provided: PROJECTS */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PROJECTS", function() { return PROJECTS; });
var PROJECTS = [
    {
        id: 1,
        title: 'ayy baboo',
        description: 'its a AYY baboo',
        difficulty: 'beginner',
        date_posted: '2018-07-29 00:45:16',
        author: {
            id: 1,
            avatar_url: 'http://dummyimage.com/200x200.jpg/5fa2dd/ffffff',
            name: 'frank',
            hireable: false,
            login: 'ayybabo29'
        }
    },
    {
        id: 2,
        title: 'FizzBuzz',
        description: 'Here are some other things that are worth thinking about: - ' +
            'the type of material. Does it have long words like ‘internationalisation’? ' +
            'If so, you’ll need more characters per line so that each line has a good chance of a coherent thought, ' +
            'and to reduce hyphenation/raggedness - the circumstances under which it is read.',
        difficulty: 'beginner',
        date_posted: '2018-07-29 00:45:16',
        author: {
            id: 69,
            avatar_url: 'http://dummyimage.com/200x200.jpg/5fa2dd/ffffff',
            name: '',
            hireable: false,
            login: 'ayYoCaptainJack4901'
        }
    },
    {
        id: 3,
        title: 'JS calculator',
        description: 'write a calculator cant u read',
        difficulty: 'beginner',
        date_posted: '2018-07-29 00:45:16',
        author: {
            id: 9,
            avatar_url: 'http://dummyimage.com/200x200.jpg/5fa2dd/ffffff',
            name: 'todd',
            hireable: true,
            login: 'nodeJSfanboy'
        }
    },
    {
        id: 4,
        title: 'tic tac toe',
        description: 'tic tac toe',
        difficulty: 'beginner',
        date_posted: '2018-07-29 00:45:16',
        author: {
            id: 29,
            avatar_url: 'http://dummyimage.com/200x200.jpg/5fa2dd/ffffff',
            name: 'joe',
            hireable: true,
            login: 'tictactoeguy'
        }
    },
    {
        id: 5,
        title: 'idk',
        description: 'use ur imagination',
        difficulty: 'beginner',
        date_posted: '2018-07-29 00:45:16',
        author: {
            id: 1,
            avatar_url: 'http://dummyimage.com/200x200.jpg/5fa2dd/ffffff',
            name: '',
            hireable: false,
            login: 'iNeed2Bebanned'
        }
    },
];


/***/ }),

/***/ "./src/app/project/project-list/project-list.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\" style=\"margin-bottom: 0\">\n  <app-header [headerText]=\"'Find and share ideas for side projects.'\"></app-header>\n  <div class=\"container-fluid\">\n    <app-project-search></app-project-search>\n\n    <ul class=\"project-list\" *ngIf=\"projectPage\" [@listStagger]=\"projectPage\">\n      <div class=\"list-info container\">\n        <h6 class=\"result-amount\">{{projectPage?.total_elements}} project(s)</h6>\n        <button id=\"post-new\" [class]=\"auth.authenticated ?\n                         'post-button btn btn-primary btn-sm' :\n                         'post-button btn btn-primary btn-sm disabled'\"\n                (click)=\"postForm()\">\n          new project\n        </button>\n        <h6>\n          <select id=\"order-select\" title=\"order\">\n            <option value=\"new\" (click)=\"ngOnInit()\">newest</option>\n            <option value=\"old\" (click)=\"sortByOldest()\">oldest</option>\n          </select>\n        </h6>\n        <ul class=\"pagination-sm\">\n          <li [class]=\"projectPage?.first ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"previousPage()\">prev</a>\n          </li>\n          <li [class]=\"projectPage?.last ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"nextPage()\">next</a>\n          </li>\n        </ul>\n      </div>\n      <li *ngFor=\"let project of projectPage?.content\">\n        <app-project-card [project]=\"project\"></app-project-card>\n      </li>\n    </ul>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-list/project-list.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".page-content .container-fluid {\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-columns: 30% auto;\n      grid-template-columns: 30% auto; }\n  .page-content .container-fluid .list-info {\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: (auto)[4];\n        grid-template-columns: repeat(4, auto);\n    margin-bottom: 1rem; }\n  .page-content .container-fluid .list-info select {\n      margin: 0;\n      width: 6rem;\n      height: 1.3rem;\n      padding: 0;\n      -ms-grid-column-align: left;\n          justify-self: left; }\n  .page-content .container-fluid .list-info .result-amount {\n      -ms-grid-column-align: start;\n          justify-self: start; }\n  .page-content .container-fluid .list-info .post-button {\n      display: flex;\n      justify-self: center; }\n  .page-content .container-fluid .list-info .pagination-sm {\n      display: flex;\n      justify-content: end; }\n"

/***/ }),

/***/ "./src/app/project/project-list/project-list.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.ts ***!
  \****************************************************************/
/*! exports provided: ProjectListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectListComponent", function() { return ProjectListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _mock_projects__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./mock-projects */ "./src/app/project/project-list/mock-projects.ts");
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var ProjectListComponent = /** @class */ (function () {
    function ProjectListComponent(projectService, auth, router) {
        this.projectService = projectService;
        this.auth = auth;
        this.router = router;
        this.mockProjects = _mock_projects__WEBPACK_IMPORTED_MODULE_1__["PROJECTS"];
    }
    ProjectListComponent.prototype.ngOnInit = function () {
        this.order = 'desc';
        this.page = 0;
        this.fetchAll(this.page, this.order);
        if (this.projectPage) {
            this.page = this.projectPage.number;
        }
    };
    ProjectListComponent.prototype.fetchAll = function (page, order) {
        var _this = this;
        this.projectService.fetchAll(page, order)
            .subscribe(function (data) { return _this.projectPage = data; }, function (error) { return console.log(error); });
    };
    ProjectListComponent.prototype.nextPage = function () {
        var _this = this;
        this.projectService.fetchAll(++this.projectPage.number, this.order)
            .subscribe(function (data) { return _this.projectPage = data; }, function (error) { return console.log(error); });
    };
    ProjectListComponent.prototype.previousPage = function () {
        var _this = this;
        this.projectService.fetchAll(--this.projectPage.number, this.order)
            .subscribe(function (data) { return _this.projectPage = data; }, function (error) { return console.log(error); });
    };
    ProjectListComponent.prototype.filterByExample = function (page, example) {
        var _this = this;
        if (this.filteredQuery !== example && example != null) {
            this.filteredQuery = example;
        }
        this.projectService.searchProjects(page, this.order, example)
            .subscribe(function (data) { return _this.projectPage = data; }, function (error) { return console.log(error); });
    };
    ProjectListComponent.prototype.postForm = function () {
        this.router.navigateByUrl('/projects/post');
    };
    ProjectListComponent.prototype.sortByOldest = function () {
        var _this = this;
        this.order = 'asc';
        if (this.filteredQuery == null) {
            this.projectService.fetchAll(0, this.order)
                .subscribe(function (data) { return _this.projectPage = data; }, function (err) { return console.log(err); });
        }
    };
    ProjectListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-list',
            template: __webpack_require__(/*! ./project-list.component.html */ "./src/app/project/project-list/project-list.component.html"),
            styles: [__webpack_require__(/*! ./project-list.component.scss */ "./src/app/project/project-list/project-list.component.scss")],
            animations: [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["trigger"])('listStagger', [
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["transition"])('* <=> *', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["query"])(':enter', [
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["style"])({ opacity: 0, transform: 'translateY(-15px)' }),
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["stagger"])('50ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["animate"])('550ms ease-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["style"])({ opacity: 1, transform: 'translateY(0px)' })))
                        ], { optional: true }),
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["query"])(':leave', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["animate"])('50ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_2__["style"])({ opacity: 0 })), {
                            optional: true
                        })
                    ])
                ])
            ]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_3__["ProjectService"], _shared_auth_service__WEBPACK_IMPORTED_MODULE_4__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]])
    ], ProjectListComponent);
    return ProjectListComponent;
}());



/***/ }),

/***/ "./src/app/project/project-post/project-post.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-post/project-post.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\">\n  <app-header [headerText]=\"'Post new project idea'\"></app-header>\n\n  <form (ngSubmit)=\"submit()\" #projectForm=\"ngForm\">\n    {{diagnostic}}\n      <div class=\"form-group\">\n        <label for=\"title\">Title</label>\n        <input type=\"text\" class=\"form-control\" id=\"title\"\n               required minlength=\"3\"\n               [(ngModel)]=\"model.title\" name=\"title\"\n               #title=\"ngModel\">\n        <div [hidden]=\"title.valid || title.pristine\"\n             class=\"alert alert-danger\">Title must be at least 3 characters long.</div>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"difficulty\">Difficulty</label>\n        <select class=\"form-control\" id=\"difficulty\" required\n                [(ngModel)]=\"model.difficulty\" name=\"difficulty\">\n          <option *ngFor=\"let diff of difficulty\" [value]=\"diff\">{{diff}}</option>\n        </select>\n      </div>\n\n      <div class=\"form-group\">\n        <label for=\"description\">Description</label>\n        <textarea type=\"text\" class=\"form-control\" id=\"description\"\n                  required minlength=\"8\"\n                  [(ngModel)]=\"model.description\" name=\"description\"\n                  #description=\"ngModel\" rows=\"3\"></textarea>\n        <div [hidden]=\"description.valid || description.pristine\"\n             class=\"alert alert-danger\">Description must be at least 8 characters long.</div>\n      </div>\n      <div class=\"form-group\">\n        <button type=\"submit\" class=\"btn btn-primary clickable\"\n                [disabled]=\"!projectForm.form.valid\">submit</button>\n      </div>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-post/project-post.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-post/project-post.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "form {\n  max-width: 600px;\n  margin: auto; }\n  form .ng-valid[required], form .ng-valid.required {\n    border-left: 5px solid green; }\n  form .ng-invalid:not(form) {\n    border-left: 5px solid darkred; }\n"

/***/ }),

/***/ "./src/app/project/project-post/project-post.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/project/project-post/project-post.component.ts ***!
  \****************************************************************/
/*! exports provided: ProjectPostComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectPostComponent", function() { return ProjectPostComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _project_search_project_creation__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../project-search/project-creation */ "./src/app/project/project-search/project-creation.ts");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var ProjectPostComponent = /** @class */ (function () {
    function ProjectPostComponent(projectService, router) {
        this.projectService = projectService;
        this.router = router;
        this.difficulty = [
            'basic',
            'beginner',
            'intermediate',
            'advanced',
            'expert'
        ];
        this.model = new _project_search_project_creation__WEBPACK_IMPORTED_MODULE_1__["ProjectCreation"]('', '', '');
        this.submitted = false;
    }
    ProjectPostComponent.prototype.submit = function () {
        this.submitted = true;
        this.projectService.post(this.model)
            .subscribe(function (status) { return console.log(status); }, function (err) { return console.log(err); });
        this.router.navigateByUrl('/projects');
    };
    Object.defineProperty(ProjectPostComponent.prototype, "diagnostic", {
        get: function () {
            return JSON.stringify(this.model);
        },
        enumerable: true,
        configurable: true
    });
    ProjectPostComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-post',
            template: __webpack_require__(/*! ./project-post.component.html */ "./src/app/project/project-post/project-post.component.html"),
            styles: [__webpack_require__(/*! ./project-post.component.scss */ "./src/app/project/project-post/project-post.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"]])
    ], ProjectPostComponent);
    return ProjectPostComponent;
}());



/***/ }),

/***/ "./src/app/project/project-search/project-creation.ts":
/*!************************************************************!*\
  !*** ./src/app/project/project-search/project-creation.ts ***!
  \************************************************************/
/*! exports provided: ProjectCreation */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectCreation", function() { return ProjectCreation; });
var ProjectCreation = /** @class */ (function () {
    function ProjectCreation(title, difficulty, description) {
        this.title = title;
        this.difficulty = difficulty;
        this.description = description;
    }
    return ProjectCreation;
}());



/***/ }),

/***/ "./src/app/project/project-search/project-search.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-search/project-search.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container translucent-form-overlay\">\n  <form class=\"form-horizontal\" (ngSubmit)=\"filterProjects()\" #searchForm=\"ngForm\">\n    <h5>Filter Projects</h5>\n    <div class=\"form-group\">\n      <label for=\"title\" class=\"col-form-label\">Title</label>\n      <input type=\"text\" class=\"form-control input-elevated\" placeholder=\"Title contains...\" id=\"title\"\n             [(ngModel)]=\"searchedQuery.title\" name=\"title\">\n    </div>\n    <div class=\"form-group\">\n      <label for=\"difficulty\" class=\"col-form-label\">Difficulty</label>\n      <select class=\"form-control\" name=\"difficulty\" id=\"difficulty\"\n              [(ngModel)]=\"searchedQuery.difficulty\">\n        <option value='' selected>All</option>\n        <option *ngFor=\"let diff of difficulty\" [value]=\"diff\">{{diff}}</option>\n      </select>\n    </div>\n    <div class=\"form-group\">\n      <label for=\"description\" class=\"col-form-label\">Description</label>\n      <textarea type=\"text\" class=\"form-control input-elevated\" placeholder=\"Description\" id=\"description\"\n                [(ngModel)]=\"searchedQuery.description\" name=\"description\" rows=\"3\"></textarea>\n    </div>\n    <button type=\"submit\" class=\"btn btn-primary clickable\">\n      Filter\n    </button>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-search/project-search.component.scss":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-search/project-search.component.scss ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".translucent-form-overlay {\n  max-width: 300px;\n  position: relative;\n  border-top: #1c2331 5px solid;\n  padding: 1em 1em 1em;\n  margin-right: 5rem; }\n  .translucent-form-overlay .columns.row {\n    display: -ms-inline-grid;\n    display: inline-grid; }\n  .translucent-form-overlay h4, .translucent-form-overlay label {\n    color: #1c2331; }\n  .translucent-form-overlay input, .translucent-form-overlay select {\n    color: gray;\n    background-color: white;\n    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.08); }\n  .translucent-form-overlay select {\n    background-position: right; }\n  .translucent-form-overlay input::-webkit-input-placeholder {\n    color: gray; }\n  .translucent-form-overlay input:-ms-input-placeholder {\n    color: gray; }\n  .translucent-form-overlay input::-ms-input-placeholder {\n    color: gray; }\n  .translucent-form-overlay input::placeholder {\n    color: gray; }\n  .translucent-form-overlay .input-elevated {\n    line-height: 1.5;\n    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.08);\n    border-radius: 5px; }\n  label {\n  font-size: 1rem !important; }\n"

/***/ }),

/***/ "./src/app/project/project-search/project-search.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/project/project-search/project-search.component.ts ***!
  \********************************************************************/
/*! exports provided: ProjectSearchComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectSearchComponent", function() { return ProjectSearchComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _project_creation__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./project-creation */ "./src/app/project/project-search/project-creation.ts");
/* harmony import */ var _project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../project-list/project-list.component */ "./src/app/project/project-list/project-list.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var ProjectSearchComponent = /** @class */ (function () {
    function ProjectSearchComponent(list) {
        this.list = list;
        this.difficulty = [
            'basic',
            'beginner',
            'intermediate',
            'advanced',
            'expert'
        ];
        this.searchedQuery = new _project_creation__WEBPACK_IMPORTED_MODULE_1__["ProjectCreation"]('', '', '');
    }
    Object.defineProperty(ProjectSearchComponent.prototype, "diagnostic", {
        get: function () {
            return JSON.stringify(this.searchedQuery);
        },
        enumerable: true,
        configurable: true
    });
    ProjectSearchComponent.prototype.filterProjects = function () {
        this.list.filterByExample(0, this.searchedQuery);
    };
    ProjectSearchComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-search',
            template: __webpack_require__(/*! ./project-search.component.html */ "./src/app/project/project-search/project-search.component.html"),
            styles: [__webpack_require__(/*! ./project-search.component.scss */ "./src/app/project/project-search/project-search.component.scss")]
        }),
        __metadata("design:paramtypes", [_project_list_project_list_component__WEBPACK_IMPORTED_MODULE_2__["ProjectListComponent"]])
    ], ProjectSearchComponent);
    return ProjectSearchComponent;
}());



/***/ }),

/***/ "./src/app/shared/auth.service.ts":
/*!****************************************!*\
  !*** ./src/app/shared/auth.service.ts ***!
  \****************************************/
/*! exports provided: AuthService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthService", function() { return AuthService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AuthService = /** @class */ (function () {
    function AuthService(http) {
        this.http = http;
        this.authenticated = false;
    }
    AuthService.prototype.authenticate = function (callback) {
        var _this = this;
        this.http.get('/api/users/me')
            .subscribe(function (data) {
            _this.authenticated = JSON.stringify(data).includes('login');
            if (_this.authenticated) {
                _this.currentUser = data;
            }
            return callback && callback();
        });
    };
    AuthService.prototype.logout = function () {
        this.currentUser = null;
        this.authenticated = false;
    };
    AuthService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], AuthService);
    return AuthService;
}());



/***/ }),

/***/ "./src/app/shared/project.service.ts":
/*!*******************************************!*\
  !*** ./src/app/shared/project.service.ts ***!
  \*******************************************/
/*! exports provided: ProjectService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectService", function() { return ProjectService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ProjectService = /** @class */ (function () {
    function ProjectService(http) {
        this.http = http;
        this.URL = '/api/projects';
    }
    ProjectService.prototype.fetchAll = function (page, sortOrder) {
        return this.http.get(this.URL + ("?page=" + page + "&sort=datePosted," + sortOrder));
    };
    ProjectService.prototype.fetchById = function (id) {
        return this.http.get(this.URL + ("/" + id));
    };
    ProjectService.prototype.post = function (project) {
        return this.http.post(this.URL, project);
    };
    // TODO remove the hardcoded sort
    ProjectService.prototype.searchProjects = function (page, sortOrder, values) {
        return this.http.get(this.URL
            + ("?title=" + values.title)
            + ("&difficulty=" + values.difficulty)
            + ("&description=" + values.description)
            + ("&page=" + page)
            + ("&sort=datePosted," + sortOrder));
    };
    ProjectService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], ProjectService);
    return ProjectService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, for easier debugging, you can ignore zone related error
 * stack frames such as `zone.run`/`zoneDelegate.invokeTask` by importing the
 * below file. Don't forget to comment it out in production mode
 * because it will have a performance impact when errors are thrown
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/Smokey/Desktop/sudocode-org/frontend/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map