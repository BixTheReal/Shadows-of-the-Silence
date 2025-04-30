#version 150 core

in vec2 texCoord;
out vec4 fragColor;

void main() {
    fragColor = vec4(texCoord, 0.0, 1.0);  // Display the UV coordinates as colors
}
