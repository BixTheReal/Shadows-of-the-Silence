#version 150 core

in vec3 Position;  // Position of geometry
in vec2 UV0;       // UV coordinates

out vec2 texCoord; // Pass UV coordinates to fragment shader

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);
    texCoord = UV0;  // Passing UV coordinates to fragment shader
}
