/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
// import errorRoute from './modules/errorRoute'
import permissionRoute from './modules/permissionRoute'

const asyncRoutes = [
  /** when your routing map is too long, you can split it into small modules **/
  permissionRoute,

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]
export default asyncRoutes
