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

/***/ "./src/app/about/about.component.html":
/*!********************************************!*\
  !*** ./src/app/about/about.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\" >\n  <app-header [headerText]=\"'About sudoCode'\"></app-header>\n    <div class=\"m-auto\">\n      <img src=\"https://i.stack.imgur.com/eQ20E.jpg\">\n    </div>\n</div>\n"

/***/ }),

/***/ "./src/app/about/about.component.scss":
/*!********************************************!*\
  !*** ./src/app/about/about.component.scss ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/about/about.component.ts":
/*!******************************************!*\
  !*** ./src/app/about/about.component.ts ***!
  \******************************************/
/*! exports provided: AboutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function() { return AboutComponent; });
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

var AboutComponent = /** @class */ (function () {
    function AboutComponent() {
    }
    AboutComponent.prototype.ngOnInit = function () {
    };
    AboutComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-about',
            template: __webpack_require__(/*! ./about.component.html */ "./src/app/about/about.component.html"),
            styles: [__webpack_require__(/*! ./about.component.scss */ "./src/app/about/about.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], AboutComponent);
    return AboutComponent;
}());



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
/* harmony import */ var _about_about_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./about/about.component */ "./src/app/about/about.component.ts");
/* harmony import */ var _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./project/project-detail/project-detail.component */ "./src/app/project/project-detail/project-detail.component.ts");
/* harmony import */ var _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./user/user-list/user-list.component */ "./src/app/user/user-list/user-list.component.ts");
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
        path: 'projects/:id',
        component: _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_5__["ProjectDetailComponent"],
        data: { title: 'Project Details' }
    },
    {
        path: 'users',
        component: _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_6__["UserListComponent"],
        data: { title: 'Users' }
    },
    {
        path: 'about',
        component: _about_about_component__WEBPACK_IMPORTED_MODULE_4__["AboutComponent"],
        data: { title: 'About' }
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

module.exports = "<div id=\"webpage\">\n<app-navbar></app-navbar>\n\n  <div id=\"content\">\n    <div id=\"sub-content\" class=\"max-width-wrapper container align-self-auto\">\n    <router-outlet></router-outlet>\n  </div>\n  </div>\n  <app-footer></app-footer>\n</div>\n"

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
/* harmony import */ var _about_about_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./about/about.component */ "./src/app/about/about.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./project/project-detail/project-detail.component */ "./src/app/project/project-detail/project-detail.component.ts");
/* harmony import */ var _comment_comment_post_comment_post_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./comment/comment-post/comment-post.component */ "./src/app/comment/comment-post/comment-post.component.ts");
/* harmony import */ var _comment_comment_card_comment_card_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./comment/comment-card/comment-card.component */ "./src/app/comment/comment-card/comment-card.component.ts");
/* harmony import */ var _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./user/user-list/user-list.component */ "./src/app/user/user-list/user-list.component.ts");
/* harmony import */ var _user_user_card_user_card_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./user/user-card/user-card.component */ "./src/app/user/user-card/user-card.component.ts");
/* harmony import */ var _shared_user_service__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./shared/user.service */ "./src/app/shared/user.service.ts");
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
                _header_header_component__WEBPACK_IMPORTED_MODULE_10__["HeaderComponent"],
                _about_about_component__WEBPACK_IMPORTED_MODULE_14__["AboutComponent"],
                _footer_footer_component__WEBPACK_IMPORTED_MODULE_15__["FooterComponent"],
                _project_project_detail_project_detail_component__WEBPACK_IMPORTED_MODULE_16__["ProjectDetailComponent"],
                _comment_comment_post_comment_post_component__WEBPACK_IMPORTED_MODULE_17__["CommentPostComponent"],
                _comment_comment_card_comment_card_component__WEBPACK_IMPORTED_MODULE_18__["CommentCardComponent"],
                _user_user_list_user_list_component__WEBPACK_IMPORTED_MODULE_19__["UserListComponent"],
                _user_user_card_user_card_component__WEBPACK_IMPORTED_MODULE_20__["UserCardComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_11__["BrowserAnimationsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormsModule"],
            ],
            providers: [
                _shared_project_service__WEBPACK_IMPORTED_MODULE_13__["ProjectService"], { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HTTP_INTERCEPTORS"], useClass: XhrInterceptor, multi: true },
                _shared_user_service__WEBPACK_IMPORTED_MODULE_21__["UserService"], { provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HTTP_INTERCEPTORS"], useClass: XhrInterceptor, multi: true }
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/comment/comment-card/comment-card.component.html":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-card/comment-card.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"comment-card container-fluid\" style=\"margin-bottom: 1.2rem\">\n  <div *ngIf=\"auth.currentUser?.id == comment?.author?.id\"\n       class=\"author-buttons btn-group-sm\">\n    <button id=\"edit\" class=\"btn btn-sm btn-outline-secondary\">\n      <i class=\"fa fa-pencil\"></i> Edit\n    </button>\n    <button id=\"delete\" class=\"btn btn-sm btn-danger\" data-toggle=\"modal\" data-target=\"#confirm-delete\">\n      <i class=\"fa fa-trash-o\"></i> Delete\n    </button>\n\n    <div class=\"modal fade\" id=\"confirm-delete\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n          <div class=\"modal-content\">\n            <div class=\"modal-header\">\n              <h5 class=\"modal-title\" id=\"exampleModalLongTitle\">Are you sure?</h5>\n              <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n                <span aria-hidden=\"true\">&times;</span>\n              </button>\n            </div>\n            <div class=\"modal-body\">\n              This cannot be undone.\n            </div>\n            <div class=\"modal-footer\">\n                <button type=\"button\" class=\"btn btn-danger\" (click)=\"deleteComment()\" data-dismiss=\"modal\">Delete Comment</button>\n              <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Close</button>\n            </div>\n          </div>\n        </div>\n      </div>\n\n\n  </div>\n  <div class=\"header\">\n    <img class=\"avatar\" src=\"{{comment?.author?.avatar_url}}\">\n    <div class=\"metadata\">\n      <a class=\"clickable login\" href=\"https://github.com/{{comment?.author?.login}}\">\n        <h6>{{comment?.author?.login}}</h6>\n      </a>\n      <div class=\"date\">{{comment?.date_posted | date: 'MMM. d, y'}}</div>\n    </div>\n  </div>\n  <p class=\"comment-body\">{{comment?.body}}</p>\n</div>\n<hr class=\"my-2\">\n"

/***/ }),

/***/ "./src/app/comment/comment-card/comment-card.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-card/comment-card.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".comment-card {\n  margin-top: 1rem;\n  padding-top: 1rem;\n  padding-bottom: 1rem; }\n  .comment-card .author-buttons {\n    float: right; }\n  .comment-card .author-buttons #delete {\n      margin-left: .5rem; }\n  .comment-card .header {\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: min-content auto;\n        grid-template-columns: -webkit-min-content auto;\n        grid-template-columns: min-content auto; }\n  .comment-card .header .avatar {\n      max-height: 50px;\n      max-width: 50px;\n      box-shadow: 0 3px .3rem black;\n      border-radius: 50px; }\n  .comment-card .header .metadata {\n      display: -ms-grid;\n      display: grid;\n      -ms-grid-rows: (auto)[2];\n          grid-template-rows: repeat(2, auto); }\n  .comment-card .header .metadata .login {\n        margin-left: 1rem;\n        font-size: 1rem;\n        margin-bottom: 0; }\n  .comment-card .header .metadata .date {\n        font-family: \"Valera Round\", sans-serif;\n        color: gray;\n        font-size: .9rem;\n        margin-left: 1rem;\n        margin-top: 0; }\n  .comment-card .comment-body {\n    margin-top: 1rem;\n    white-space: pre-wrap;\n    font-family: \"Valera Round\", sans-serif;\n    font-size: .95rem;\n    padding-bottom: 0;\n    margin-bottom: 0; }\n"

/***/ }),

/***/ "./src/app/comment/comment-card/comment-card.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/comment/comment-card/comment-card.component.ts ***!
  \****************************************************************/
/*! exports provided: CommentCardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentCardComponent", function() { return CommentCardComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
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




var CommentCardComponent = /** @class */ (function () {
    function CommentCardComponent(auth, projectService, route) {
        var _this = this;
        this.auth = auth;
        this.projectService = projectService;
        this.route = route;
        this.route.params.subscribe(function (params) { return _this.projectId = params.id; }, function (err) { return console.log(err); });
    }
    CommentCardComponent.prototype.ngOnInit = function () {
    };
    CommentCardComponent.prototype.deleteComment = function () {
        this.projectService.deleteComment(this.projectId, this.comment.id)
            .subscribe(function () { }, function (err) { return console.log(err); });
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], CommentCardComponent.prototype, "comment", void 0);
    CommentCardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-comment-card',
            template: __webpack_require__(/*! ./comment-card.component.html */ "./src/app/comment/comment-card/comment-card.component.html"),
            styles: [__webpack_require__(/*! ./comment-card.component.scss */ "./src/app/comment/comment-card/comment-card.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"],
            _shared_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"]])
    ], CommentCardComponent);
    return CommentCardComponent;
}());



/***/ }),

/***/ "./src/app/comment/comment-post/comment-creation.ts":
/*!**********************************************************!*\
  !*** ./src/app/comment/comment-post/comment-creation.ts ***!
  \**********************************************************/
/*! exports provided: CommentCreation */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentCreation", function() { return CommentCreation; });
var CommentCreation = /** @class */ (function () {
    function CommentCreation(body) {
        this.body = body;
    }
    return CommentCreation;
}());



/***/ }),

/***/ "./src/app/comment/comment-post/comment-post.component.html":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-post/comment-post.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<form  (ngSubmit)=\"submit()\" #commentForm=\"ngForm\" >\n  <div class=\"form-group\">\n    <label for=\"comment-body\">\n      <span *ngIf=\"auth.authenticated\">Post comment</span>\n      <span *ngIf=\"!auth.authenticated\">\n        <a class=\"clickable\" href=\"http://localhost:8080/oauth2/authorization/github\">Log in to post a comment</a></span>\n    </label>\n    <textarea [disabled]=\"!auth.authenticated\" type=\"text\" class=\"form-control\" id=\"comment-body\"\n              required minlength=\"3\" rows=\"3\" maxlength=\"255\"\n    [(ngModel)]=\"comment.body\" name=\"body\"></textarea>\n  </div>\n  <div class=\"form-group\">\n\n    <button type=\"submit\" class=\"btn btn-primary btn-sm clickable\"\n            [disabled]=\"!commentForm.form.valid\">Post</button>\n\n  </div>\n</form>\n\n"

/***/ }),

/***/ "./src/app/comment/comment-post/comment-post.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/comment/comment-post/comment-post.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/comment/comment-post/comment-post.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/comment/comment-post/comment-post.component.ts ***!
  \****************************************************************/
/*! exports provided: CommentPostComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentPostComponent", function() { return CommentPostComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _comment_creation__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./comment-creation */ "./src/app/comment/comment-post/comment-creation.ts");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var CommentPostComponent = /** @class */ (function () {
    function CommentPostComponent(auth, projectService, route, router) {
        this.auth = auth;
        this.projectService = projectService;
        this.route = route;
        this.router = router;
        this.submitted = false;
        this.comment = new _comment_creation__WEBPACK_IMPORTED_MODULE_1__["CommentCreation"]('');
    }
    CommentPostComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.route.params.subscribe(function (params) { return _this.projectId = params.id; }, function (err) { return console.log(err); });
    };
    CommentPostComponent.prototype.submit = function () {
        var submittedComment;
        this.projectService.postComment(this.projectId, this.comment)
            .subscribe(function (data) { return submittedComment = data; }, function (err) { return console.log(err); });
        if (submittedComment) {
            this.submitted = true;
        }
        this.router.navigate(['projects', this.projectId]).then(function () { });
    };
    Object.defineProperty(CommentPostComponent.prototype, "diagnostic", {
        get: function () {
            return JSON.stringify(this.comment);
        },
        enumerable: true,
        configurable: true
    });
    CommentPostComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-comment-post',
            template: __webpack_require__(/*! ./comment-post.component.html */ "./src/app/comment/comment-post/comment-post.component.html"),
            styles: [__webpack_require__(/*! ./comment-post.component.scss */ "./src/app/comment/comment-post/comment-post.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_auth_service__WEBPACK_IMPORTED_MODULE_2__["AuthService"],
            _shared_project_service__WEBPACK_IMPORTED_MODULE_3__["ProjectService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]])
    ], CommentPostComponent);
    return CommentPostComponent;
}());



/***/ }),

/***/ "./src/app/footer/footer.component.html":
/*!**********************************************!*\
  !*** ./src/app/footer/footer.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<footer>\n  <div class=\"max-width-wrapper container\">\n    <div id=\"footer-content\" class=\"container\" style=\"min-height: 5rem\">\n      This site was created using Spring Boot & Angular 6\n    </div>\n  </div>\n</footer>\n"

/***/ }),

/***/ "./src/app/footer/footer.component.scss":
/*!**********************************************!*\
  !*** ./src/app/footer/footer.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "footer {\n  background-color: #1c2331;\n  position: static;\n  bottom: 0;\n  width: 100%;\n  height: 200px; }\n  footer .max-width-wrapper {\n    color: #fffbfe; }\n  footer .max-width-wrapper #footer-content {\n      padding-top: 1rem;\n      font-family: \"Valera Round\", sans-serif;\n      font-size: 1rem; }\n"

/***/ }),

/***/ "./src/app/footer/footer.component.ts":
/*!********************************************!*\
  !*** ./src/app/footer/footer.component.ts ***!
  \********************************************/
/*! exports provided: FooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function() { return FooterComponent; });
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

var FooterComponent = /** @class */ (function () {
    function FooterComponent() {
    }
    FooterComponent.prototype.ngOnInit = function () {
    };
    FooterComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-footer',
            template: __webpack_require__(/*! ./footer.component.html */ "./src/app/footer/footer.component.html"),
            styles: [__webpack_require__(/*! ./footer.component.scss */ "./src/app/footer/footer.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], FooterComponent);
    return FooterComponent;
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

module.exports = "#header {\n  margin-bottom: 3rem;\n  padding-top: 5rem; }\n  #header h2 {\n    font-family: Montserrat, sans-serif;\n    font-weight: 600; }\n"

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

module.exports = "<nav class=\"navbar navbar-expand-sm navbar-dark\">\n  <div id=\"inner-nav\" class=\"container max-width-wrapper\">\n    <a class=\"navbar-brand\" routerLink=\"/\">(sudoCode);</a>\n    <button class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#mainNav\">\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <div class=\"collapse navbar-collapse\" id=\"mainNav\">\n      <div class=\"navbar-expand\">\n        <div class=\"navbar-nav\">\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             [routerLinkActiveOptions]=\"{exact: true}\" routerLink=\"/\">Home</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             routerLink=\"projects\">Projects</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             routerLink=\"users\">Users</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             routerLink=\"#\">Contact</a>\n          <a class=\"nav-item nav-link\" routerLinkActive=\"active\"\n             routerLink=\"about\">About</a>\n        </div>\n      </div>\n    </div>\n    <div class=\"mavbar-expand ml-auto\">\n      <div class=\"navbar-nav\" *ngIf=\"!auth.authenticated\">\n        <a class=\"nav-item nav-link\" href=\"http://localhost:8080/oauth2/authorization/github\">\n          <i class=\"fa fa-github fa-lg\"></i> <span> Login</span>\n        </a>\n      </div>\n      <li class=\"nav-item dropdown\" *ngIf=\"auth.authenticated\">\n        <a class=\"nav-link dropdown-toggle\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\"\n           aria-haspopup=\"true\" aria-expanded=\"false\">\n          <span class=\"login\">{{auth.currentUser?.login}} </span>\n          <img src=\"{{auth.currentUser?.avatar_url}}\" style=\"max-width: 40px; border-radius: 50px; padding: 0; margin: 0\">\n        </a>\n        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n          <a class=\"dropdown-item\" (click)=\"auth.logout()\" style=\"cursor: pointer\">Logout</a>\n        </div>\n      </li>\n    </div>\n  </div>\n</nav>\n"

/***/ }),

/***/ "./src/app/navbar/navbar.component.scss":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.scss ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".navbar {\n  background-color: #1c2331 !important;\n  font-size: .9rem;\n  font-family: Montserrat, sans-serif;\n  min-height: 56px;\n  padding-bottom: 0;\n  padding-top: 0;\n  box-sizing: border-box;\n  box-shadow: 0 5px 21px -11px rgba(31, 31, 33, 0.62);\n  border-top: 4px solid #639fab; }\n  .navbar .navbar-brand {\n    font-size: 1.5rem;\n    font-weight: 700; }\n  .navbar .container {\n    width: 88vw;\n    min-height: 80px; }\n  .navbar .container .nav-link {\n      text-transform: uppercase;\n      font-size: .9rem;\n      font-weight: 700;\n      letter-spacing: 0;\n      cursor: pointer;\n      color: rgba(255, 251, 254, 0.7); }\n  .navbar .container .nav-link:hover {\n        color: white; }\n  .navbar .container .active {\n      border-bottom: 2px solid #639fab;\n      color: white; }\n  .dropdown-toggle::after {\n  display: none; }\n  .login {\n  padding-right: 1rem;\n  color: #f1f1f1; }\n  @media screen and (max-width: 700px) {\n    .login {\n      display: none; } }\n"

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

module.exports = "<div id=\"project-card\" class=\"container\">\n  <h4><a class=\"title\" (click)=\"getDetails()\">{{project?.title}}</a>\n    <span id=\"difficulty\" class=\"badge font-weight-normal\">({{project?.difficulty}})</span>\n    <span *ngIf=\"auth.authenticated && (project?.author === auth?.currentUser)\" class=\"float-right\">\n      <i class=\"fa-trash\"></i>\n    </span>\n  </h4>\n  <!--<h6 id=\"difficulty\">{{project.difficulty}}</h6>-->\n  <p class=\"text-body\" id=\"description\">{{project?.description}}</p>\n  <hr class=\"my-2\">\n  <h6 id=\"metadata\">\n      <span class=\"user-details\">\n        <img src=\"{{project?.author.avatar_url}}\" class=\"avatar\">\n        {{project?.author.login}}</span>\n      <span class=\"date\">{{project?.date_posted | date: 'MMM. d, y'}}</span>\n  </h6>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-card/project-card.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-card/project-card.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#project-card {\n  border-radius: 5px;\n  margin-top: 4rem; }\n  #project-card .title {\n    color: #1c2331;\n    font-family: \"Montserrat\", sans-serif;\n    font-weight: 500; }\n  #project-card .title:hover {\n      color: #639fab;\n      cursor: pointer; }\n  #project-card #description {\n    font-size: 1rem;\n    margin-left: .5rem;\n    word-wrap: break-spaces;\n    white-space: pre-wrap; }\n  #project-card #metadata {\n    font-size: .9rem;\n    padding-top: .5rem;\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: (auto)[2];\n        grid-template-columns: repeat(2, auto); }\n  #project-card #metadata .user-details {\n      -ms-grid-column-align: left;\n          justify-self: left; }\n  #project-card #metadata .user-details .avatar {\n        max-height: 20px;\n        box-shadow: 0 0 .1rem black;\n        border-radius: 50px; }\n  #project-card #metadata .date {\n      -ms-grid-column-align: right;\n          justify-self: right; }\n  #project-card #difficulty {\n    color: gray;\n    padding-bottom: 1rem; }\n"

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
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
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



var ProjectCardComponent = /** @class */ (function () {
    function ProjectCardComponent(auth, router) {
        this.auth = auth;
        this.router = router;
    }
    ProjectCardComponent.prototype.ngOnInit = function () {
    };
    ProjectCardComponent.prototype.getDetails = function () {
        this.router.navigateByUrl("/projects/" + this.project.id);
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
        __metadata("design:paramtypes", [_shared_auth_service__WEBPACK_IMPORTED_MODULE_1__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], ProjectCardComponent);
    return ProjectCardComponent;
}());



/***/ }),

/***/ "./src/app/project/project-detail/project-detail.component.html":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-detail/project-detail.component.html ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\">\n  <app-header [headerText]=\"'Project Details'\"></app-header>\n  <div class=\"container-fluid\">\n    <div id=\"project-details\" class=\"container\">\n      <div id=\"details-header\">\n        <span class=\"title\">{{project?.title}}</span>\n        <span class=\"date\">{{project?.date_posted | date: 'MMM. d, y'}}</span>\n      </div>\n      <div class=\"metadata\">\n        <span class=\"difficulty\">{{project?.difficulty}}</span>\n        <span id=\"user-info\">\n          <span class=\"author-avatar\">\n            <img src=\"{{project?.author?.avatar_url}}\" alt=\"avatar\">\n          </span>\n          <span class=\"author-login\">{{project?.author?.login}}</span>\n        </span>\n      </div>\n      <div class=\"project-description container\">\n        <p class=\"text\">{{project?.description}}</p>\n      </div>\n      <div class=\"author-buttons\" *ngIf=\"isAuthor()\" id=\"options\">\n        <button id=\"edit\" class=\"btn btn-sm btn-outline-secondary\">\n          <i class=\"fa fa-pencil\"></i> Edit\n        </button>\n        <button id=\"delete\" class=\"btn btn-sm btn-danger\" (click)=\"deleteProject()\">\n          <i class=\"fa fa-trash\"></i> Delete</button>\n      </div>\n    </div>\n    <div id=\"comments\" class=\"container\">\n      <div class=\"comment-post-form\">\n        <hr class=\"my-2\">\n        <app-comment-post></app-comment-post>\n      </div>\n      <div class=\"comment-list-metadata\">\n        <div class=\"result-number\">{{comments?.total_elements}} comment(s)</div>\n        <select class=\"sort-order\" title=\"order\">\n          <option value=\"new\" (click)=\"sortByNewest()\">newest</option>\n          <option value=\"old\" (click)=\"sortByOldest()\">oldest</option>\n        </select>\n        <ul class=\"pagination-sm\">\n          <li [class]=\"comments?.first ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"prevCommentPage()\">prev</a>\n          </li>\n          <li [class]=\"comments?.last ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"nextCommentPage()\">next</a>\n          </li>\n        </ul>\n      </div>\n        <ul class=\"comment-list\" [@listStagger]=\"comments\">\n          <li *ngFor=\"let comment of comments?.content\">\n            <app-comment-card [comment]=\"comment\"></app-comment-card>\n          </li>\n        </ul>\n    </div>\n  </div>\n\n  <ul class=\"pagination-sm d-flex float-right\" style=\"margin-right: 3rem\">\n    <li [class]=\"comments?.first ? 'page-item disabled' : 'page-item'\">\n      <a class=\"page-link\" (click)=\"prevCommentPage()\">prev</a>\n    </li>80px\n    <li [class]=\"comments?.last ? 'page-item disabled' : 'page-item'\">\n      <a class=\"page-link\" (click)=\"nextCommentPage()\">next</a>\n    </li>\n  </ul>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-detail/project-detail.component.scss":
/*!**********************************************************************!*\
  !*** ./src/app/project/project-detail/project-detail.component.scss ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#project-details {\n  -ms-grid-rows: (auto)[2];\n      grid-template-rows: repeat(2, auto); }\n  #project-details #details-header {\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: (auto)[2];\n        grid-template-columns: repeat(2, auto); }\n  #project-details #details-header .title {\n      font-family: Montserrat, sans-serif;\n      font-weight: 500;\n      font-size: 1.5rem;\n      margin-bottom: 1rem; }\n  #project-details #details-header .date {\n      -ms-grid-column-align: end;\n          justify-self: end; }\n  #project-details .metadata {\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: (auto)[2];\n        grid-template-columns: repeat(2, auto); }\n  #project-details .metadata .difficulty {\n      font-size: 1rem;\n      color: gray;\n      font-family: \"Valera Round\", sans-serif; }\n  #project-details .metadata #user-info {\n      -ms-grid-column-align: end;\n          justify-self: end; }\n  #project-details .metadata #user-info .author-avatar img {\n        max-height: 20px;\n        max-width: 20px;\n        border-radius: 50px; }\n  #project-details .metadata #user-info .author-login {\n        padding-left: .3rem;\n        font-size: 1rem; }\n  #project-details .project-description {\n    margin-top: 1.5rem;\n    white-space: pre-wrap; }\n  #project-details .project-description .text {\n      font-size: 1rem;\n      word-wrap: break-word; }\n  #project-details .author-buttons {\n    max-width: -webkit-fit-content;\n    max-width: -moz-fit-content;\n    max-width: fit-content;\n    float: right; }\n  #project-details .author-buttons #delete {\n      margin-left: .5rem; }\n  #comments {\n  font-family: \"Valera Round\", sans-serif;\n  font-size: 1rem;\n  padding-bottom: 5rem; }\n  #comments .comment-list-metadata {\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: (auto)[3];\n        grid-template-columns: repeat(3, auto); }\n  #comments .comment-list-metadata .result-amount {\n      -ms-grid-column-align: start;\n          justify-self: start; }\n  #comments .comment-list-metadata .sort-order {\n      margin: 0;\n      width: 6rem;\n      height: 1.3rem;\n      padding: 0;\n      -ms-grid-column-align: center;\n          justify-self: center; }\n  #comments .comment-list-metadata .pagination-sm {\n      display: flex;\n      justify-content: end; }\n  #comments .comment-post-form {\n    padding-top: 2rem; }\n  #comments .comment-list {\n    list-style-type: none;\n    padding: 0; }\n"

/***/ }),

/***/ "./src/app/project/project-detail/project-detail.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/project/project-detail/project-detail.component.ts ***!
  \********************************************************************/
/*! exports provided: ProjectDetailComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectDetailComponent", function() { return ProjectDetailComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");
/* harmony import */ var _shared_sort_order__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../shared/sort-order */ "./src/app/shared/sort-order.ts");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var ProjectDetailComponent = /** @class */ (function () {
    function ProjectDetailComponent(projectService, route, auth, router) {
        var _this = this;
        this.projectService = projectService;
        this.route = route;
        this.auth = auth;
        this.router = router;
        this.route.params.subscribe(function (params) { return _this.projectId = params.id; }, function (err) { return console.log(err); });
    }
    ProjectDetailComponent.prototype.isAuthor = function () {
        if (this.auth.currentUser == null) {
            return false;
        }
        if (this.project == null) {
            return false;
        }
        return this.auth.currentUser.id === this.project.author.id;
    };
    ProjectDetailComponent.prototype.deleteProject = function () {
        if (this.isAuthor()) {
            this.projectService.deleteProject(this.projectId)
                .subscribe(function (status) { return console.log(status); }, function (err) { return console.log(err); });
            this.router.navigate(['projects']).then(function () { });
        }
    };
    ProjectDetailComponent.prototype.ngOnInit = function () {
        this.pageNum = 0;
        this.fetchProject();
        this.sortByNewest();
    };
    ProjectDetailComponent.prototype.sortByOldest = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_4__["SortOrder"].ASC;
        this.fetchComments();
    };
    ProjectDetailComponent.prototype.sortByNewest = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_4__["SortOrder"].DESC;
        this.fetchComments();
    };
    ProjectDetailComponent.prototype.fetchProject = function () {
        var _this = this;
        this.projectService.fetchById(this.projectId)
            .subscribe(function (data) { return _this.project = data; }, function (err) { return console.log(err); });
    };
    ProjectDetailComponent.prototype.nextCommentPage = function () {
        if (!this.comments.last) {
            this.pageNum++;
            this.fetchComments();
        }
    };
    ProjectDetailComponent.prototype.prevCommentPage = function () {
        if (!this.comments.first) {
            this.pageNum--;
            this.fetchComments();
        }
    };
    ProjectDetailComponent.prototype.fetchComments = function () {
        var _this = this;
        this.projectService.fetchProjectComments(this.projectId, this.order, this.pageNum)
            .subscribe(function (data) { return _this.comments = data; }, function (err) { return console.log(err); });
    };
    ProjectDetailComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-detail',
            template: __webpack_require__(/*! ./project-detail.component.html */ "./src/app/project/project-detail/project-detail.component.html"),
            styles: [__webpack_require__(/*! ./project-detail.component.scss */ "./src/app/project/project-detail/project-detail.component.scss")],
            animations: [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_3__["trigger"])('listStagger', [
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_3__["transition"])('* <=> *', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_3__["query"])(':enter', [
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_3__["style"])({ opacity: 0, transform: 'translateY(-15px)' }),
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_3__["stagger"])('50ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_3__["animate"])('550ms ease-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_3__["style"])({ opacity: 1, transform: 'translateY(0px)' })))
                        ], { optional: true }),
                    ])
                ])
            ]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_1__["ProjectService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            _shared_auth_service__WEBPACK_IMPORTED_MODULE_5__["AuthService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], ProjectDetailComponent);
    return ProjectDetailComponent;
}());



/***/ }),

/***/ "./src/app/project/project-list/project-list.component.html":
/*!******************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\" >\n  <app-header [headerText]=\"'Find and share ideas for side projects.'\"></app-header>\n  <div class=\"container-fluid\">\n    <app-project-search></app-project-search>\n\n    <ul class=\"project-list\" *ngIf=\"projectPage\" [@listStagger]=\"projectPage\">\n      <div class=\"list-info container\">\n        <h6 class=\"result-amount\">{{projectPage?.total_elements}} project(s)</h6>\n        <button id=\"post-new\" [disabled]=\"!auth.authenticated\"\n                class=\"post-button btn btn-primary btn-sm\"\n                (click)=\"postForm()\">\n          New\n        </button>\n        <h6>\n          <select id=\"order-select\" title=\"order\">\n            <option value=\"new\" (click)=\"ngOnInit()\">newest</option>\n            <option value=\"old\" (click)=\"sortByOldest()\">oldest</option>\n          </select>\n        </h6>\n        <ul class=\"pagination-sm\">\n          <li [class]=\"projectPage?.first ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"previousPage()\">prev</a>\n          </li>\n          <li [class]=\"projectPage?.last ? 'page-item disabled' : 'page-item'\">\n            <a class=\"page-link\" (click)=\"nextPage()\">next</a>\n          </li>\n        </ul>\n      </div>\n      <li *ngFor=\"let project of projectPage?.content\">\n        <app-project-card [project]=\"project\"></app-project-card>\n      </li>\n    </ul>\n\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project-list/project-list.component.scss":
/*!******************************************************************!*\
  !*** ./src/app/project/project-list/project-list.component.scss ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".page-content .container-fluid {\n  display: -ms-grid;\n  display: grid; }\n  @media screen and (min-width: 850px) {\n    .page-content .container-fluid {\n      -ms-grid-columns: 30% auto;\n          grid-template-columns: 30% auto; } }\n  @media screen and (max-width: 850px) {\n    .page-content .container-fluid app-project-search {\n      display: none; } }\n  .page-content .container-fluid .list-info {\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: (auto)[4];\n        grid-template-columns: repeat(4, auto);\n    margin-bottom: 1rem; }\n  .page-content .container-fluid .list-info select {\n      margin: 0;\n      width: 6rem;\n      height: 1.3rem;\n      padding: 0;\n      -ms-grid-column-align: left;\n          justify-self: left; }\n  .page-content .container-fluid .list-info .result-amount {\n      -ms-grid-column-align: start;\n          justify-self: start; }\n  .page-content .container-fluid .list-info .post-button {\n      display: flex;\n      justify-self: center; }\n  .page-content .container-fluid .list-info .pagination-sm {\n      display: flex;\n      justify-content: end; }\n"

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
/* harmony import */ var _angular_animations__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/animations */ "./node_modules/@angular/animations/fesm5/animations.js");
/* harmony import */ var _shared_project_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/project.service */ "./src/app/shared/project.service.ts");
/* harmony import */ var _shared_auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../shared/auth.service */ "./src/app/shared/auth.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _shared_sort_order__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../shared/sort-order */ "./src/app/shared/sort-order.ts");
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
    }
    ProjectListComponent.prototype.ngOnInit = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_5__["SortOrder"].DESC;
        this.page = 0;
        this.fetchAll(this.page, this.order);
        if (this.projectPage) {
            this.page = this.projectPage.number;
        }
    };
    /**
     * Returns a ProjectPage of all projects in the backend DB with no filtering
     * other than the required page & order.
     * @param page Page number. Starts at 0.
     * @param order Order of the projects. Must be a SortOrder enum.
     */
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
            .subscribe(function (data) { return _this.projectPage = data; }, function (err) { return console.log(err); });
    };
    ProjectListComponent.prototype.filterByExample = function (page, example) {
        var _this = this;
        if (this.filteredQuery !== example && example != null) {
            this.filteredQuery = example;
        }
        this.projectService.searchProjects(page, this.order, example)
            .subscribe(function (data) { return _this.projectPage = data; }, function (err) { return console.log(err); });
    };
    ProjectListComponent.prototype.postForm = function () {
        this.router.navigate(['projects', 'post'])
            .then(function () { });
    };
    ProjectListComponent.prototype.sortByOldest = function () {
        var _this = this;
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_5__["SortOrder"].ASC;
        this.projectService.fetchAll(0, this.order)
            .subscribe(function (data) { return _this.projectPage = data; }, function (err) { return console.log(err); });
    };
    ProjectListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-project-list',
            template: __webpack_require__(/*! ./project-list.component.html */ "./src/app/project/project-list/project-list.component.html"),
            styles: [__webpack_require__(/*! ./project-list.component.scss */ "./src/app/project/project-list/project-list.component.scss")],
            animations: [
                Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["trigger"])('listStagger', [
                    Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["transition"])('* <=> *', [
                        Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["query"])(':enter', [
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({ opacity: 0, transform: 'translateY(-15px)' }),
                            Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["stagger"])('50ms', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["animate"])('550ms ease-out', Object(_angular_animations__WEBPACK_IMPORTED_MODULE_1__["style"])({ opacity: 1, transform: 'translateY(0px)' })))
                        ], { optional: true }),
                    ])
                ])
            ]
        }),
        __metadata("design:paramtypes", [_shared_project_service__WEBPACK_IMPORTED_MODULE_2__["ProjectService"], _shared_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]])
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

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\">\n  <app-header [headerText]=\"'Post new project idea'\"></app-header>\n\n  <form (ngSubmit)=\"submit()\" #projectForm=\"ngForm\">\n    {{diagnostic}}\n      <div class=\"form-group\">\n        <label for=\"title\">Title</label>\n        <input type=\"text\" class=\"form-control\" id=\"title\"\n               required minlength=\"5\" maxlength=\"30\"\n               [(ngModel)]=\"model.title\" name=\"title\"\n               #title=\"ngModel\">\n        <div [hidden]=\"title.valid || title.pristine\"\n             class=\"alert alert-danger\">Title must be 5-30 characters long.</div>\n      </div>\n      <div class=\"form-group\">\n        <label for=\"difficulty\">Difficulty</label>\n        <select class=\"form-control\" id=\"difficulty\" required\n                [(ngModel)]=\"model.difficulty\" name=\"difficulty\">\n          <option *ngFor=\"let diff of difficulty\" [value]=\"diff\">{{diff}}</option>\n        </select>\n      </div>\n\n      <div class=\"form-group\">\n        <label for=\"description\">Description</label>\n        <textarea type=\"text\" class=\"form-control\" id=\"description\"\n                  required minlength=\"8\"\n                  [(ngModel)]=\"model.description\" name=\"description\"\n                  #description=\"ngModel\" rows=\"3\"></textarea>\n        <div [hidden]=\"description.valid || description.pristine\"\n             class=\"alert alert-danger\">Description must be at least 8 characters long.</div>\n      </div>\n      <div class=\"form-group\">\n        <button type=\"submit\" class=\"btn btn-primary clickable\"\n                [disabled]=\"!projectForm.form.valid\">submit</button>\n      </div>\n  </form>\n</div>\n"

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
        this.router.navigateByUrl('/projects').then(function () { });
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
/**
 * A class for a project without ID and User fields.
 *
 * Suitable as a project post-form as well as a model for filtering via REST calls.
 */
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

module.exports = ".translucent-form-overlay {\n  max-width: 300px;\n  position: relative;\n  border-top: #1c2331 5px solid;\n  padding: 1em 1em 1em;\n  margin-right: 5rem; }\n  @media screen and (max-width: 850px) {\n    .translucent-form-overlay {\n      display: none; } }\n  .translucent-form-overlay .columns.row {\n    display: -ms-inline-grid;\n    display: inline-grid; }\n  .translucent-form-overlay h4, .translucent-form-overlay label {\n    color: #1c2331; }\n  .translucent-form-overlay input, .translucent-form-overlay select {\n    color: gray;\n    background-color: white;\n    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.08); }\n  .translucent-form-overlay select {\n    background-position: right; }\n  .translucent-form-overlay input::-webkit-input-placeholder {\n    color: gray; }\n  .translucent-form-overlay input:-ms-input-placeholder {\n    color: gray; }\n  .translucent-form-overlay input::-ms-input-placeholder {\n    color: gray; }\n  .translucent-form-overlay input::placeholder {\n    color: gray; }\n  .translucent-form-overlay .input-elevated {\n    line-height: 1.5;\n    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.08);\n    border-radius: 5px; }\n  label {\n  font-size: 1rem !important; }\n"

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
    /**
     * Returns a ProjectPage of all projects in the backend DB with no filtering other than the required page & order.
     * @param page Page number. Starts at 0.
     * @param sortOrder Order of the projects. Must either be 'desc' or 'asc'.
     */
    ProjectService.prototype.fetchAll = function (page, sortOrder) {
        return this.http.get(this.URL + "?page=" + page + "&sort=datePosted," + sortOrder);
    };
    ProjectService.prototype.fetchById = function (id) {
        return this.http.get(this.URL + "/" + id);
    };
    ProjectService.prototype.post = function (project) {
        return this.http.post(this.URL, project);
    };
    ProjectService.prototype.postComment = function (projectId, comment) {
        return this.http.post(this.URL + "/" + projectId + "/comments", comment);
    };
    ProjectService.prototype.fetchProjectComments = function (projectId, sortOrder, pageNum) {
        return this.http.get(this.URL + "/" + projectId + "/comments?page=" + pageNum + "&sort=datePosted," + sortOrder);
    };
    ProjectService.prototype.deleteComment = function (projectId, commentId) {
        return this.http.delete(this.URL + "/" + projectId + "/comments/" + commentId);
    };
    ProjectService.prototype.deleteProject = function (projectId) {
        return this.http.delete(this.URL + "/" + projectId);
    };
    ProjectService.prototype.editComment = function (comment) {
        // todo
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

/***/ "./src/app/shared/sort-order.ts":
/*!**************************************!*\
  !*** ./src/app/shared/sort-order.ts ***!
  \**************************************/
/*! exports provided: SortOrder */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SortOrder", function() { return SortOrder; });
var SortOrder;
(function (SortOrder) {
    SortOrder["ASC"] = "asc";
    SortOrder["DESC"] = "desc";
})(SortOrder || (SortOrder = {}));


/***/ }),

/***/ "./src/app/shared/user.service.ts":
/*!****************************************!*\
  !*** ./src/app/shared/user.service.ts ***!
  \****************************************/
/*! exports provided: UserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserService", function() { return UserService; });
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


var UserService = /** @class */ (function () {
    function UserService(http) {
        this.http = http;
        this.URL = '/api/users';
    }
    UserService.prototype.fetchById = function (id) {
        return this.http.get(this.URL + "/" + id);
    };
    UserService.prototype.fetchAll = function (page, sortOrder) {
        return this.http.get(this.URL + "?page=" + page + "&sort=" + sortOrder);
    };
    UserService = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"])({
            providedIn: 'root'
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], UserService);
    return UserService;
}());



/***/ }),

/***/ "./src/app/user/user-card/user-card.component.html":
/*!*********************************************************!*\
  !*** ./src/app/user/user-card/user-card.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"user-card\">\n  <div id=\"user-info\">\n    <img class=\"avatar\" src=\"{{user?.avatar_url}}\">\n    <div class=\"metadata\">\n      <div class=\"login\">{{user?.login}}</div>\n      <div *ngIf=\"user?.hireable\" class=\"hireable\">Looking for work</div>\n      <div id=\"user-icon-links\">\n      <a class=\"github-url\" href=\"https://github.com/{{user?.login}}\">\n        <i class=\"fa fa-github fa-2x\"></i></a>\n      </div>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/user/user-card/user-card.component.scss":
/*!*********************************************************!*\
  !*** ./src/app/user/user-card/user-card.component.scss ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#user-card {\n  max-width: -webkit-fit-content;\n  max-width: -moz-fit-content;\n  max-width: fit-content;\n  -ms-grid-column-align: center;\n      justify-self: center;\n  margin-bottom: 3rem; }\n  #user-card #user-info {\n    display: -ms-grid;\n    display: grid;\n    -ms-grid-columns: min-content auto;\n        grid-template-columns: -webkit-min-content auto;\n        grid-template-columns: min-content auto; }\n  #user-card #user-info .avatar {\n      max-height: 75px;\n      max-width: 75px;\n      border-radius: 50px;\n      box-shadow: 0 3px .3rem black; }\n  #user-card #user-info .metadata {\n      display: -ms-grid;\n      display: grid;\n      font-size: 1rem;\n      margin-left: 1rem;\n      -ms-grid-rows: (min-content)[3];\n          grid-template-rows: repeat(3, -webkit-min-content);\n          grid-template-rows: repeat(3, min-content); }\n  #user-card #user-info .metadata .login {\n        font-family: Montserrat, sans-serif !important;\n        font-size: 1.2rem;\n        color: #1c2331; }\n  #user-card #user-info .metadata .hireable {\n        font-family: \"Valera Round\", sans-serif;\n        font-size: .95rem;\n        color: gray; }\n  #user-card #user-info .metadata #user-icon-links {\n        font-size: .7rem;\n        margin-top: .3rem; }\n"

/***/ }),

/***/ "./src/app/user/user-card/user-card.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/user/user-card/user-card.component.ts ***!
  \*******************************************************/
/*! exports provided: UserCardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserCardComponent", function() { return UserCardComponent; });
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

var UserCardComponent = /** @class */ (function () {
    function UserCardComponent() {
    }
    UserCardComponent.prototype.ngOnInit = function () {
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"])(),
        __metadata("design:type", Object)
    ], UserCardComponent.prototype, "user", void 0);
    UserCardComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-user-card',
            template: __webpack_require__(/*! ./user-card.component.html */ "./src/app/user/user-card/user-card.component.html"),
            styles: [__webpack_require__(/*! ./user-card.component.scss */ "./src/app/user/user-card/user-card.component.scss")]
        }),
        __metadata("design:paramtypes", [])
    ], UserCardComponent);
    return UserCardComponent;
}());



/***/ }),

/***/ "./src/app/user/user-list/user-list.component.html":
/*!*********************************************************!*\
  !*** ./src/app/user/user-list/user-list.component.html ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid max-width-wrapper page-content\" >\n  <app-header [headerText]=\"'Users'\"></app-header>\n  <ul class=\"user-list\" *ngIf=\"users\">\n    <li *ngFor=\"let user of users?.content\">\n      <app-user-card [user]=\"user\"></app-user-card>\n    </li>\n  </ul>\n</div>\n"

/***/ }),

/***/ "./src/app/user/user-list/user-list.component.scss":
/*!*********************************************************!*\
  !*** ./src/app/user/user-list/user-list.component.scss ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".user-list li {\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-columns: (auto)[4];\n      grid-template-columns: repeat(4, auto); }\n"

/***/ }),

/***/ "./src/app/user/user-list/user-list.component.ts":
/*!*******************************************************!*\
  !*** ./src/app/user/user-list/user-list.component.ts ***!
  \*******************************************************/
/*! exports provided: UserListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserListComponent", function() { return UserListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shared_user_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../shared/user.service */ "./src/app/shared/user.service.ts");
/* harmony import */ var _shared_sort_order__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../shared/sort-order */ "./src/app/shared/sort-order.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var UserListComponent = /** @class */ (function () {
    function UserListComponent(userService) {
        this.userService = userService;
    }
    UserListComponent.prototype.ngOnInit = function () {
        this.order = _shared_sort_order__WEBPACK_IMPORTED_MODULE_2__["SortOrder"].DESC;
        this.pageNum = 0;
        this.fetchAll(this.pageNum, this.order);
        if (this.users) {
            this.pageNum = this.users.number;
        }
    };
    UserListComponent.prototype.fetchAll = function (page, order) {
        var _this = this;
        this.userService.fetchAll(page, order)
            .subscribe(function (data) { return _this.users = data; }, function (err) { return console.log(err); });
    };
    UserListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-user-list',
            template: __webpack_require__(/*! ./user-list.component.html */ "./src/app/user/user-list/user-list.component.html"),
            styles: [__webpack_require__(/*! ./user-list.component.scss */ "./src/app/user/user-list/user-list.component.scss")]
        }),
        __metadata("design:paramtypes", [_shared_user_service__WEBPACK_IMPORTED_MODULE_1__["UserService"]])
    ], UserListComponent);
    return UserListComponent;
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