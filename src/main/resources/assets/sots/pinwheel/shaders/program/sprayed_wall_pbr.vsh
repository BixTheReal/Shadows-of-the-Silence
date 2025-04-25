#version 150

in vec3 aPosition;
in vec2 aTexCoord;

out vec2 vTexCoord;

uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;

void main() {
    vTexCoord = aTexCoord;
    gl_Position = projection * view * model * vec4(aPosition, 1.0);
}
