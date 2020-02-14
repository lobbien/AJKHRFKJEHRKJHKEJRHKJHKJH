#ifdef GL_ES
#define LOWP lowp
    precision mediump float;
#else
    #define LOWP
#endif

varying LOWP vec4 v_color;
varying vec2 v_texCoords;

uniform sampler2D u_texture;
/*

uniform sampler2D u_texture;
varying vec4 v_color;
varying vec2 v_texCoord;


void main() {
    vec4 tex = texture2D(u_texture, v_texCoord);
    vec3 texColor = texture2D(u_texture, v_texCoord).rgb;
    float r = tex.b;
    float g = tex.r;
    float b = tex.g;
    gl_FragColor = v_color * vec4(r, g, b, tex.a);
    texture2D(u_texture, v_texCoords);
}*/

void main()
{
    vec4 tex = texture2D(u_texture, v_texCoords);
    vec4 v_color_new = v_color;
    float r =  v_color.b * tex.b;
    float g =  v_color.r * tex.r;
    float b =  v_color.g * tex.g;
    v_color_new.r = r;
    v_color_new.g = g;
    v_color_new.b = b;
    gl_FragColor = v_color_new * vec4(r, g, b, tex.a);
}
